package org.fasttrack.infrastrucutre.financialdata.webscrap;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fasttrack.domain.financialdata.FinancialDataFetchable;
import org.fasttrack.domain.financialdata.dto.server.FinancialDataResponseFromServerDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

@AllArgsConstructor
@Log4j2
public class FinancialDataFetchableJsoupAleo implements FinancialDataFetchable {


    @Override
    public FinancialDataResponseFromServerDto fetchFinancialDataByCompanyName(final String name) {
        try {




            //to działa :)
            // Adres URL strony do pobrania
            String url = "https://aleo.com/int/company/mikrobit-spolka-z-ograniczona-odpowiedzialnoscia";

            // Pobieranie zawartości strony jako obiekt Document
            Document doc = Jsoup.connect(url).get();

            // Wyświetlanie tytułu strony
            System.out.println("Tytuł strony: " + doc.title());


            // Znajdź wszystkie tr, które zawierają "Equity"
            Element equityRow = doc.select("tr:contains(Net sales)").first();

            if (equityRow != null) {
                // Znajdź wszystkie komórki w danym wierszu
                Elements cells = equityRow.select("td");
                // Sprawdź, czy mamy co najmniej trzy komórki
                if (cells.size() >= 4) {
                    // Pobierz trzy wartości liczbowe z trzech ostatnich komórek
                    String value1 = cells.get(1).text();
                    String value2 = cells.get(2).text();
                    String value3 = cells.get(3).text();
                    // Wyświetl wartości
                    System.out.println("Wartość 1: " + value1);
                    System.out.println("Wartość 2: " + value2);
                    System.out.println("Wartość 3: " + value3);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

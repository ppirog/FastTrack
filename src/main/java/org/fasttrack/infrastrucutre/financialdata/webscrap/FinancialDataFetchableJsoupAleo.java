package org.fasttrack.infrastrucutre.financialdata.webscrap;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fasttrack.domain.financialdata.FinancialDataFetchable;
import org.fasttrack.domain.financialdata.dto.server.FinancialDataResponseFromServerDto;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Log4j2
@Service
public class FinancialDataFetchableJsoupAleo implements FinancialDataFetchable {

    final String ALEO_URl = "https://aleo.com/int/company/";
    final String NET_SALES = "Net sales";
    final String EBITDA = "EBITDA";
    final String NET_PROFIT_OR_LOSS = "Net profit / loss";
    final String LIABILITIES_AND_PROVISIONS = "Liabilities and provisions";
    final String EQUITY = "Equity";
    final String TOTAL_ASSETS = "Total assets";
    private final CompanyNameStringParser companyNameStringParser;

    @Override
    public Optional<FinancialDataResponseFromServerDto> fetchFinancialDataByCompanyName(final String name) {
        String nameToProcess = name;

        int count = 0;
        while (count < 4) {
            try {

                final String parsedCompanyName = companyNameStringParser.parseCompanyName(nameToProcess);

                String url = ALEO_URl + parsedCompanyName;
                log.info("PARSED STRING : {}", url);
                Document doc = Jsoup.connect(url).get();

                log.info("Title: {}", doc.title());


                Elements h3Elements = doc.select("h3");

                String krsText = "";

                for (Element h3Element : h3Elements) {

                    if (h3Element.text().contains("KRS")) {

                        Element divElement = h3Element.nextElementSibling();

                        if (divElement != null) {
                            final String divKrs = divElement.text().trim();
                            System.out.println("Numer KRS: " + divKrs);
                            krsText = divKrs;
                        } else {
                            System.out.println("Nie znaleziono numeru KRS.");
                        }
                        break;
                    }
                }

                Element netSalesRow = doc.select("tr:contains(" + NET_SALES + ")").first();

                Element ebitdaRow = doc.select("tr:contains(" + EBITDA + ")").first();

                Element netProfitLossRow = doc.select("tr:contains(" + NET_PROFIT_OR_LOSS + ")").first();

                Element liabilitiesRow = doc.select("tr:contains(" + LIABILITIES_AND_PROVISIONS + ")").first();

                Element equityRow = doc.select("tr:contains(" + EQUITY + ")").first();

                Element totalAssetsRow = doc.select("tr:contains(" + TOTAL_ASSETS + ")").first();


                List<String> netSales = new ArrayList<>();
                List<String>  ebitda = new ArrayList<>();
                List<String> netProfitOrLoss  = new ArrayList<>();
                List<String> liabilitedAndProvisions  = new ArrayList<>();
                List<String> equity  = new ArrayList<>();
                List<String> totalAssets  = new ArrayList<>();

                if (netSalesRow != null) {
                    Elements netSalesCells = netSalesRow.select("td");
                    List<String> listOfValuesFromCells = getListOfValuesFromCells(netSalesCells);

                    List<String> ab = new ArrayList<>();
                    for(String a : listOfValuesFromCells){
                        ab.add(a.replace(",","."));
                    }
                    netSales.addAll(ab);

                    log.info("Net sales: {}", netSales);
                }

                if (ebitdaRow != null) {
                    Elements ebitdaCells = ebitdaRow.select("td");
                    List<String> listOfValuesFromCells = getListOfValuesFromCells(ebitdaCells);
                    List<String> ab = new ArrayList<>();
                    for(String a : listOfValuesFromCells){
                        ab.add(a.replace(",","."));
                    }
                    ebitda.addAll(ab);
                    log.info("EBITDA: {}", ebitda);
                }

                if (netProfitLossRow != null) {
                    Elements netProfitLossCells = netProfitLossRow.select("td");
                    List<String> listOfValuesFromCells = getListOfValuesFromCells(netProfitLossCells);
                    List<String> ab = new ArrayList<>();
                    for(String a : listOfValuesFromCells){
                        ab.add(a.replace(",","."));
                    }
                    netProfitOrLoss.addAll(ab);
                    log.info("Net profit / loss: {}", netProfitOrLoss);
                }

                if (liabilitiesRow != null) {
                    Elements netProfitLossCells = liabilitiesRow.select("td");
                    List<String> listOfValuesFromCells = getListOfValuesFromCells(netProfitLossCells);
                    List<String> ab = new ArrayList<>();
                    for(String a : listOfValuesFromCells){
                        ab.add(a.replace(",","."));
                    }
                    liabilitedAndProvisions.addAll(ab);
                    log.info("Liabilities and provisions: {}", liabilitedAndProvisions);
                }

                if (equityRow != null) {
                    Elements netProfitLossCells = equityRow.select("td");
                    List<String> listOfValuesFromCells = getListOfValuesFromCells(netProfitLossCells);
                    List<String> ab = new ArrayList<>();
                    for(String a : listOfValuesFromCells){
                        ab.add(a.replace(",","."));
                    }
                    equity.addAll(ab);
                    log.info("Equity: {}", equity);
                }

                if (totalAssetsRow != null) {
                    Elements netProfitLossCells = totalAssetsRow.select("td");
                    List<String> listOfValuesFromCells = getListOfValuesFromCells(netProfitLossCells);
                    List<String> ab = new ArrayList<>();
                    for(String a : listOfValuesFromCells){
                        ab.add(a.replace(",","."));
                    }
                    totalAssets.addAll(ab);
                    log.info("TotalAssets: {}", totalAssets);
                }

                if (
                        netSales.isEmpty() ||
                                ebitda.isEmpty() ||
                                netProfitOrLoss.isEmpty()
                ) {
                    return Optional.empty();
                }

                return Optional.ofNullable(FinancialDataResponseFromServerDto.builder()
                        .companyName(name)
                        .krsNumber(krsText)
                        .netSalesPercentageChange(netSales)
                        .ebitdaChangePercentageChange(ebitda)
                        .netProfitOrLossPercentageChange(netProfitOrLoss)
                        .equityPercentageChange(equity)
                        .liabilitedAndProvisionsPercentageChange(liabilitedAndProvisions)
                        .totalAssetsPercentageChange(totalAssets)
                        .build());

            } catch (HttpStatusException e) {
                count++;
                if (count == 1) {
                    nameToProcess = name.split(" ")[0];
                } else if (count == 2) {
                    nameToProcess = name.split(" ")[0] + "-sp-zoo";
                } else {
                    nameToProcess = name.split(" ")[0] + "-sp-z-oo";
                }
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }

        return Optional.empty();
    }

    private List<String> getListOfValuesFromCells(Elements cells) {
        final int size = cells.size();
        log.info("Cells size: {}Fetch from (cells size - 1) {}", size, size - 1);

        List<String> strings = new ArrayList<>();
        for(int i = size - 2; i >= 1; i--) {
            log.info("Cell: {}", cells.get(i).text());
            strings.add(cells.get(i).text());
        }

        return strings;
    }
}

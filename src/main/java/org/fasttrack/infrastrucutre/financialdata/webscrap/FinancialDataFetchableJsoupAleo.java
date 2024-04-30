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

    final String ALEO_URl = "https://aleo.com/int/company/";
    final String NET_SALES = "Net sales";
    final String EBITDA = "EBITDA";
    final String NET_PROFIT_OR_LOSS = "Net profit / loss";
    final String LIABILITIES_AND_PROVISIONS = "Liabilities and provisions";
    final String EQUITY = "Equity";
    final String TOTAL_ASSETS = "Total assets";
    private final CompanyNameStringParser companyNameStringParser;

    @Override
    public FinancialDataResponseFromServerDto fetchFinancialDataByCompanyName(final String name) {
        try {

            final String parsedCompanyName = companyNameStringParser.parseCompanyName(name);

            String url = ALEO_URl + parsedCompanyName;
            log.info("PARSED STRING : {}", url);
            Document doc = Jsoup.connect(url).get();

            log.info("Title: {}", doc.title());


            Element netSalesRow = doc.select("tr:contains(" + NET_SALES + ")").first();

            Element ebitdaRow = doc.select("tr:contains(" + EBITDA + ")").first();

            Element netProfitLossRow = doc.select("tr:contains(" + NET_PROFIT_OR_LOSS + ")").first();

            Element liabilitiesRow = doc.select("tr:contains(" + LIABILITIES_AND_PROVISIONS + ")").first();

            Element equityRow = doc.select("tr:contains(" + EQUITY + ")").first();

            Element totalAssetsRow = doc.select("tr:contains(" + TOTAL_ASSETS + ")").first();


            String netSales = "";
            String ebitda = "";
            String netProfitOrLoss = "";
            String liabilitedAndProvisions = "";
            String equity = "";
            String totalAssets = "";

            if (netSalesRow != null) {
                Elements netSalesCells = netSalesRow.select("td");
                netSales = getValueFromCells(netSalesCells).replace(",",".");
                log.info("Net sales: {}", netSales);
            }

            if (ebitdaRow != null) {
                Elements ebitdaCells = ebitdaRow.select("td");
                ebitda = getValueFromCells(ebitdaCells).replace(",",".");
                log.info("EBITDA: {}", ebitda);
            }

            if (netProfitLossRow != null) {
                Elements netProfitLossCells = netProfitLossRow.select("td");
                netProfitOrLoss = getValueFromCells(netProfitLossCells).replace(",",".");
                log.info("Net profit / loss: {}", netProfitOrLoss);
            }

            if (liabilitiesRow != null) {
                Elements liabilitiesCells = liabilitiesRow.select("td");
                liabilitedAndProvisions = getValueFromCells(liabilitiesCells).replace(",",".");
                log.info("Liabilities and provisions: {}", liabilitedAndProvisions);
            }

            if (equityRow != null) {
                Elements equityCells = equityRow.select("td");
                equity = getValueFromCells(equityCells).replace(",",".");
                log.info("Equity: {}", equity);
            }

            if (totalAssetsRow != null) {
                Elements totalAssetsCells = totalAssetsRow.select("td");
                totalAssets = getValueFromCells(totalAssetsCells).replace(",",".");
                log.info("Total assets: {}", totalAssets);
            }

            return FinancialDataResponseFromServerDto.builder()
                    .netSalesPercentageChange(netSales)
                    .ebitdaChangePercentageChange(ebitda)
                    .netProfitOrLossPercentageChange(netProfitOrLoss)
                    .equityPercentageChange(equity)
                    .liabilitedAndProvisionsPercentageChange(liabilitedAndProvisions)
                    .totalAssetsPercentageChange(totalAssets)
                    .build();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String getValueFromCells(Elements cells) {
        final int size = cells.size();
        log.info("Cells size: {}Fetch from (cells size - 1) {}", size, size - 1);
        return cells.get(size - 1).text();
    }
}

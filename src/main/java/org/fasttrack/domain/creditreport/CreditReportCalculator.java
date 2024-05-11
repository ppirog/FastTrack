package org.fasttrack.domain.creditreport;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fasttrack.domain.financialdata.dto.FinancialDataResponseDto;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Log4j2
class CreditReportCalculator {
    CreditReport calculateCreditScoring(final FinancialDataResponseDto financialDataResponseDto) {
        int maxScoring = 0;
        int companyScoring = 0;
        final List<String> netProfitOrLossValues = financialDataResponseDto.netProfitOrLossValues();
        final List<String> ebitdaValues = financialDataResponseDto.ebitdaValues();
        final List<String> netSalesValues = financialDataResponseDto.netSalesValues();
        final List<String> assetsValues = financialDataResponseDto.totalAssetsValues();
        final List<String> equityValues = financialDataResponseDto.equityValues();
        final List<String> liabilitesAndProvisionsValues = financialDataResponseDto.liabilitesAndProvisionsValues();

        //netprofit or loss
        if (!netProfitOrLossValues.isEmpty()) {
            maxScoring += 10;
            companyScoring += calculateProfitValues(netProfitOrLossValues);

        }


        return null;
    }

    private int calculateProfitValues(final List<String> netProfitOrLossValues) {
        int result = 0;

        List<Double> netDoubleList = new ArrayList<>();

        for (int i = netProfitOrLossValues.size() - 1; i >= 0; i--) {
            netDoubleList.add(Double.valueOf(netProfitOrLossValues.get(i)));
        }

        //calculate how many years existr profit (5 max)
        int profitsCounter = 0;
        for (Double d : netDoubleList) {
            if (d > 0) {
                profitsCounter++;
            }
        }

        double wsk = (double) profitsCounter / (double) netProfitOrLossValues.size();
        result += (int) (wsk * 5);
        if(netProfitOrLossValues.size() == 1){
            result = result * (1/2);
        }

        return result;
    }
}

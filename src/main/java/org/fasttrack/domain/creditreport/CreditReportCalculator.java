package org.fasttrack.domain.creditreport;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fasttrack.domain.financialdata.dto.FinancialDataResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Log4j2
@Service
class CreditReportCalculator {

    CreditReport calculateCreditScoring(final FinancialDataResponseDto financialDataResponseDto) {
        int maxScoring = 0;
        int companyScoring = 0;
        List<String> descriptions = new ArrayList<>();

        final List<String> netProfitOrLossValues = financialDataResponseDto.netProfitOrLossValues();
        final List<String> ebitdaValues = financialDataResponseDto.ebitdaValues();
        final List<String> netSalesValues = financialDataResponseDto.netSalesValues();
        final List<String> assetsValues = financialDataResponseDto.totalAssetsValues();
        final List<String> equityValues = financialDataResponseDto.equityValues();
        final List<String> liabilitesAndProvisionsValues = financialDataResponseDto.liabilitesAndProvisionsValues();


        if(netProfitOrLossValues.size() > 1) {
            final int profitValues = calculateProfitValues(netProfitOrLossValues);
            companyScoring += profitValues;
            maxScoring += 5;
            if(profitValues <= 2){
                descriptions.add("Net profit values are negative");
            }

            final int changes = calculateChanges(netProfitOrLossValues);
            companyScoring += changes;
            maxScoring += 5;
            if(changes <= 2){
                descriptions.add("Net profit changes are negative");
            }
        }

        if(ebitdaValues.size() > 1) {
            final int ebitdaValuesScoring = calculateChanges(ebitdaValues);
            companyScoring += ebitdaValuesScoring;
            maxScoring += 5;
            if(ebitdaValuesScoring <= 2){
                descriptions.add("EBITDA values are negative");
            }

            final int ebitdaProfitValues = calculateProfitValues(ebitdaValues);
            companyScoring += ebitdaProfitValues;
            maxScoring += 5;

            if(ebitdaProfitValues <= 2){
                descriptions.add("EBITDA changes are negative");
            }
        }

        if(netSalesValues.size() > 1) {
            final int netSalesValuesScoring = calculateChanges(netSalesValues);
            companyScoring += netSalesValuesScoring;
            maxScoring += 5;
            if(netSalesValuesScoring <= 2){
                descriptions.add("Net sales values are negative");
            }

            final int netSalesProfitValues = calculateProfitValues(netSalesValues);
            companyScoring += netSalesProfitValues;
            maxScoring += 5;
            if(netSalesProfitValues <= 2){
                descriptions.add("Net sales changes are negative");
            }
        }

        if(assetsValues.size() > 1) {
            final int assetsValuesScoring = calculateProfitValues(assetsValues);

            companyScoring += assetsValuesScoring;
            maxScoring += 5;
            if(assetsValuesScoring <= 2){
                descriptions.add("Assets values are negative");
            }


            //changes
            final int assetsValuesChanges = calculateChanges(assetsValues);
            companyScoring += assetsValuesChanges;
            maxScoring += 5;
            if(assetsValuesChanges <= 2){
                descriptions.add("Assers changes are negative");
            }
        }

        if(equityValues.size() > 1) {
            final int equityValuesScoring = calculateProfitValues(equityValues);
            companyScoring += equityValuesScoring;
            maxScoring += 5;
            if(equityValuesScoring <= 2){
                descriptions.add("Equity values are negative");
            }

            final int equityValuesChanges = calculateChanges(equityValues);
            companyScoring += equityValuesChanges;
            maxScoring += 5;
            if(equityValuesChanges <= 2){
                descriptions.add("Equity changes are negative");
            }
        }

        if(liabilitesAndProvisionsValues.size() > 1) {
            final int liabilitiesIsLowerThanAssets = calculateIfLiabilitiesIsLowerThanAssets(liabilitesAndProvisionsValues, assetsValues);
            companyScoring += liabilitiesIsLowerThanAssets;
            maxScoring += 5;
            if(liabilitiesIsLowerThanAssets <= 2){
                descriptions.add("Liaibilities are higher than 50% of assets");
            }

            final int liabilitiesIsDescresing = calculateIfLiabilitiesIsDescresing(liabilitesAndProvisionsValues);
            companyScoring += liabilitiesIsDescresing;
            maxScoring += 5;
            if(liabilitiesIsDescresing <= 2){
                descriptions.add("Liabilities are increasing");
            }
        }


        log.info("Company scoring: {}", companyScoring);
        log.info("Max scoring: {}", maxScoring);

        double percentageFraction = ((double) companyScoring /(double)  maxScoring);
        Long percentage = (long) (percentageFraction * 100);
        log.info("Percentage scoring: {}", percentage);
        return CreditReport.builder()
                .percentageScore(percentage)
                .descriptions(descriptions)
                .comapnyName(financialDataResponseDto.companyName())
                .krsNumber(financialDataResponseDto.krsNumber())
                .build();
    }

    private int calculateIfLiabilitiesIsLowerThanAssets(final List<String> liabilitesAndProvisionsValues, final List<String> assetsValues) {

        int result = 0;
        List<Double> netDoubleList = new ArrayList<>();

        for (int i = assetsValues.size() - 1; i >= 0; i--) {
            netDoubleList.add(Double.valueOf(liabilitesAndProvisionsValues.get(i)));
        }

        List<Double> assetsDoubleList = new ArrayList<>();

        for (int i = assetsValues.size() - 1; i >= 0; i--) {
            assetsDoubleList.add(Double.valueOf(assetsValues.get(i)));
        }

        int profitsCounter = 0;
        double previousValue = 0;

        for (int i = 0; i < netDoubleList.size(); i++) {
            if (netDoubleList.get(i) < assetsDoubleList.get(i)) {
                profitsCounter++;
            }
        }

        double wsk = (double) profitsCounter / (double) liabilitesAndProvisionsValues.size();
        result += (int) (wsk * 5);

        return liabilitesAndProvisionsValues.size() != 1 ? result : (int) (result * 0.5);
    }


    private int calculateIfLiabilitiesIsDescresing(final List<String> liabilitesAndProvisionsValues) {
        int result = 0;
        List<Double> netDoubleList = new ArrayList<>();

        for (int i = 0; i < liabilitesAndProvisionsValues.size(); i++) {
            netDoubleList.add(Double.valueOf(liabilitesAndProvisionsValues.get(i)));
        }

        int profitsCounter = 0;
        double previousValue = 0;

        for (Double d : netDoubleList) {
            if (d < previousValue) {
                profitsCounter++;
            }
            previousValue = d;
        }

        double wsk = (double) profitsCounter / (double) liabilitesAndProvisionsValues.size();
        result += (int) (wsk * 5);

        return liabilitesAndProvisionsValues.size() != 1 ? result : (int) (result * 0.5);

    }

    private int calculateChanges(final List<String> netProfitOrLossValues) {

        int result = 0;
        List<Double> netDoubleList = new ArrayList<>();

        for (int i = netProfitOrLossValues.size() - 1; i >= 0; i--) {
            netDoubleList.add(Double.valueOf(netProfitOrLossValues.get(i)));
        }

        int profitsCounter = 0;
        double previousValue = 0;

        for (Double d : netDoubleList) {
            if (d > previousValue) {
                profitsCounter++;
            }
            previousValue = d;
        }

        double wsk = (double) profitsCounter / (double) netProfitOrLossValues.size();
        result += (int) (wsk * 5);

        return netProfitOrLossValues.size() != 1 ? result : (int) (result * 0.5);
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

        return netProfitOrLossValues.size() != 1 ? result : (int) (result * 0.5);
    }
}

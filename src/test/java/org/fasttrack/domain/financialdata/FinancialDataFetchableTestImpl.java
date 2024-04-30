package org.fasttrack.domain.financialdata;

import org.fasttrack.domain.financialdata.dto.server.FinancialDataResponseFromServerDto;

import java.util.Optional;

class FinancialDataFetchableTestImpl implements FinancialDataFetchable{
    @Override
    public Optional<FinancialDataResponseFromServerDto> fetchFinancialDataByCompanyName(final String name) {
        return Optional.ofNullable(FinancialDataResponseFromServerDto.builder()
                .companyName(name)
                .krsNumber("00000001")
                .netSalesPercentageChange("134.3")
                .ebitdaChangePercentageChange("230.3")
                .netProfitOrLossPercentageChange("227.2")
                .liabilitedAndProvisionsPercentageChange("111.6")
                .equityPercentageChange("339.5")
                .totalAssetsPercentageChange("181.4")
                .build());
    }
}

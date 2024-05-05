package org.fasttrack.domain.financialdata;

import org.fasttrack.domain.financialdata.dto.server.FinancialDataResponseFromServerDto;

import java.util.List;
import java.util.Optional;

class FinancialDataFetchableTestImpl implements FinancialDataFetchable{
    @Override
    public Optional<FinancialDataResponseFromServerDto> fetchFinancialDataByCompanyName(final String name) {
        return Optional.ofNullable(FinancialDataResponseFromServerDto.builder()
                .companyName(name)
                .krsNumber("00000001")
                .netSalesPercentageChange(List.of("134.3"))
                .ebitdaChangePercentageChange(List.of("230.3"))
                .netProfitOrLossPercentageChange(List.of("227.2"))
                .liabilitedAndProvisionsPercentageChange(List.of("111.6"))
                .equityPercentageChange(List.of("339.5"))
                .totalAssetsPercentageChange(List.of("181.4"))
                .build());
    }
}

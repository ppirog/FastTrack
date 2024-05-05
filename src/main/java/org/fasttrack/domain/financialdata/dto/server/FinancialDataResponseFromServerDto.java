package org.fasttrack.domain.financialdata.dto.server;

import lombok.Builder;

import java.util.List;

@Builder
public record FinancialDataResponseFromServerDto(
        String krsNumber,
        String companyName,

        List<String> netSalesPercentageChange,
        List<String>  ebitdaChangePercentageChange,
        List<String>  netProfitOrLossPercentageChange,
        List<String>  liabilitedAndProvisionsPercentageChange,
        List<String>  equityPercentageChange,
        List<String>  totalAssetsPercentageChange
) {
}

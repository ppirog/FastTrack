package org.fasttrack.domain.financialdata.dto.server;

import lombok.Builder;

@Builder
public record FinancialDataResponseFromServerDto(
        String netSalesPercentageChange,
        String ebitdaChangePercentageChange,
        String netProfitOrLossPercentageChange,
        String liabilitedAndProvisionsPercentageChange,
        String equityPercentageChange,
        String totalAssetsPercentageChange
) {
}

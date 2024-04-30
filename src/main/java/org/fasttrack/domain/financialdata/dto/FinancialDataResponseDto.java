package org.fasttrack.domain.financialdata.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record FinancialDataResponseDto(
        LocalDateTime fetchDate,
        String krsNumber,
        String companyName,

        String netSalesPercentageChange,
        String ebitdaChangePercentageChange,
        String netProfitOrLossPercentageChange,
        String liabilitedAndProvisionsPercentageChange,
        String equityPercentageChange,
        String totalAssetsPercentageChange
) {
}

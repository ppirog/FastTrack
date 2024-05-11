package org.fasttrack.domain.financialdata.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record FinancialDataResponseDto(
        LocalDateTime fetchDate,
        String krsNumber,
        String companyName,

        List<String> netSalesValues,
        List<String> ebitdaValues,
        List<String> netProfitOrLossValues,
        List<String> liabilitesAndProvisionsValues,
        List<String> equityValues,
        List<String> totalAssetsValues
) {
}

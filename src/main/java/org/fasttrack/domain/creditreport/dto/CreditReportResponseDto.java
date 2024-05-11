package org.fasttrack.domain.creditreport.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record CreditReportResponseDto(
        Long percentageScore,
        List<String> descriptions
) {
}

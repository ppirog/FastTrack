package org.fasttrack.domain.creditreport.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record CreditReportResponseDto(
        String krsNumber,
        String comapnyName,
        Long percentageScore,
        List<String> descriptions
) {
}

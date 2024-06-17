package org.fasttrack.infrastrucutre.creditreport.dto;

import lombok.Builder;

@Builder
public record DeleteCreditReportResponseDto(
        long deletedCreditReports
) {
}

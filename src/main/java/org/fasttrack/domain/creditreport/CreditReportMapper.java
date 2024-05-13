package org.fasttrack.domain.creditreport;

import org.fasttrack.domain.creditreport.dto.CreditReportResponseDto;
import org.springframework.stereotype.Component;

@Component
class CreditReportMapper {

        public CreditReportResponseDto toDto(CreditReport creditReport) {
            return CreditReportResponseDto.builder()
                    .krsNumber(creditReport.getKrsNumber())
                    .comapnyName(creditReport.getComapnyName())
                    .percentageScore(creditReport.getPercentageScore())
                    .descriptions(creditReport.getDescriptions())
                    .build();
        }
}

package org.fasttrack.domain.creditreport;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fasttrack.domain.creditreport.dto.CreditReportResponseDto;
import org.fasttrack.domain.financialdata.FinancialDataFacade;
import org.fasttrack.domain.financialdata.dto.FinancialDataResponseDto;

@Log4j2
@AllArgsConstructor
public class CreditReportFacade {

    private final FinancialDataFacade financialDataFacade;
    private final CreditReportCalculator creditReportCalculator;

    public CreditReportResponseDto fetchCreditReportByKrs(String krs){

        final FinancialDataResponseDto financialDataResponseDto = financialDataFacade.fetchFinancialDataByKrs(krs);
        creditReportCalculator.calculateCreditScoring(financialDataResponseDto);


        return CreditReportResponseDto.builder().build();
    }
}

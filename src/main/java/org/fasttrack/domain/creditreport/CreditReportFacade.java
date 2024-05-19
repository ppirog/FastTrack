package org.fasttrack.domain.creditreport;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fasttrack.domain.creditreport.dto.CreditReportResponseDto;
import org.fasttrack.domain.financialdata.FinancialDataFacade;
import org.fasttrack.domain.financialdata.dto.FinancialDataResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Log4j2
@AllArgsConstructor
@Component
public class CreditReportFacade {

    private final FinancialDataFacade financialDataFacade;
    private final CreditReportCalculator creditReportCalculator;
    private final CreditReportMapper creditReportMapper;
    private final CreditReportRepository creditReportRepository;

    public CreditReportResponseDto fetchCreditReportByKrs(String krs){

        final FinancialDataResponseDto financialDataResponseDto = financialDataFacade.fetchFinancialDataByKrs(krs);
        final CreditReport creditReport = creditReportCalculator.calculateCreditScoring(financialDataResponseDto);

        final List<CreditReport> byKrsNumber = creditReportRepository.findByKrsNumber(krs);
        if(!byKrsNumber.isEmpty()){
            final CreditReport report = byKrsNumber.get(0);
            if(report.equals(creditReport)){
                return creditReportMapper.toDto(report);
            }
        }

        CreditReport save  = creditReportRepository.save(creditReport);
        return creditReportMapper.toDto(save);
    }
}

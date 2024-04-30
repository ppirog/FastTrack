package org.fasttrack.domain.financialdata;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fasttrack.domain.company.CompanyFacade;
import org.fasttrack.domain.company.dto.CompanyResponseDto;
import org.fasttrack.domain.financialdata.dto.FinancialDataResponseDto;

@Log4j2
@AllArgsConstructor
public class FinancialDataFacade {

    private final CompanyFacade companyFacade;

    public FinancialDataResponseDto fetchFinancialDataByKrs(String krs) {
        log.info("Fetching financial data for company with KRS: {}", krs);
        final CompanyResponseDto companyByKrsIfNotExistInDbFetchAndSave = companyFacade.findCompanyByKrsIfNotExistInDbFetchAndSave(krs);
        log.info("Company fetched: {}", companyByKrsIfNotExistInDbFetchAndSave);




        return FinancialDataResponseDto.builder().build();
    }



}

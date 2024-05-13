package org.fasttrack.domain.financialdata;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fasttrack.domain.company.CompanyFacade;
import org.fasttrack.domain.company.dto.CompanyResponseDto;
import org.fasttrack.domain.financialdata.dto.FinancialDataResponseDto;
import org.fasttrack.domain.financialdata.dto.server.FinancialDataResponseFromServerDto;
import org.fasttrack.domain.financialdata.exceptions.NotFoundInRemoteServerException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Log4j2
@AllArgsConstructor
@Component
public class FinancialDataFacade {

    private final CompanyFacade companyFacade;
    private final FinancialDataFetchable dataFetchable;
    private final FinancialDataRepository financialDataRepository;
    private final FinancialDataMapper mapper;
    private final LocalDateTime dateTime;

    public FinancialDataResponseDto fetchFinancialDataByKrs(String krs) {
        log.info("Fetching financial data for company with KRS: {}", krs);
        final CompanyResponseDto companyByKrsIfNotExistInDbFetchAndSave = companyFacade.findCompanyByKrsIfNotExistInDbFetchAndSave(krs);
        log.info("Company fetched: {}", companyByKrsIfNotExistInDbFetchAndSave);

        final List<FinancialData> byKrsFromDb = financialDataRepository.findByKrsNumberOrderByFetchDateDesc(krs);
        if(!byKrsFromDb.isEmpty()){
            final FinancialData data = byKrsFromDb.get(0);
            if(data.getFetchDate().getYear() == dateTime.getYear()){
                return mapper.toDto(data);
            }
        }

        final String fullName = companyByKrsIfNotExistInDbFetchAndSave.name();
        final FinancialDataResponseFromServerDto financialDataResponseFromServerDto = dataFetchable.fetchFinancialDataByCompanyName(fullName)
                .orElseThrow(() -> new NotFoundInRemoteServerException("Financial data: " + fullName + " not available!"));

        final FinancialData entityFromServer = mapper.toEntity(financialDataResponseFromServerDto);
        log.info(entityFromServer);


        List<FinancialData> byKRSnumberFromDatabase = financialDataRepository.findByKrsNumberOrderByFetchDateDesc(entityFromServer.getKrsNumber());

        FinancialData saved;
        if (!byKRSnumberFromDatabase.isEmpty()) {
            if (!byKRSnumberFromDatabase.get(0).areEqualDataExceptFetchDateAndId(entityFromServer)) {
                saved = financialDataRepository.save(entityFromServer);
            } else {
                saved = byKRSnumberFromDatabase.get(0);
            }
        } else {
            saved = financialDataRepository.save(entityFromServer);
        }
        log.info("Saving to database: {}", saved);

        return mapper.toDto(saved);
    }


}
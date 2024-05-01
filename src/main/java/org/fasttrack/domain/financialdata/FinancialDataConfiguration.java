package org.fasttrack.domain.financialdata;

import org.fasttrack.domain.company.CompanyFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
class FinancialDataConfiguration {

    @Bean
    public FinancialDataMapper mapper(LocalDateTime dateTime){
        return new FinancialDataMapper(dateTime);
    }

    @Bean
    public FinancialDataFacade financialDataFacade(
            CompanyFacade companyFacade,
            FinancialDataFetchable dataFetchable,
            FinancialDataRepository repository,
            FinancialDataMapper mapper
    ) {

        return new FinancialDataFacade(companyFacade, dataFetchable, repository, mapper);
    }
}

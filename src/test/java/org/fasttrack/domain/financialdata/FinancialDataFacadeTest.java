package org.fasttrack.domain.financialdata;

import org.fasttrack.domain.company.CompanyFacade;
import org.fasttrack.domain.company.dto.CompanyResponseDto;
import org.fasttrack.domain.financialdata.dto.FinancialDataResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FinancialDataFacadeTest {

    private final CompanyFacade companyFacade = mock(CompanyFacade.class);
    private FinancialDataFacade financialDataFacade;

    @BeforeEach
    void setUp() {

        financialDataFacade = new FinancialDataFacade(
                companyFacade,
                new FinancialDataFetchableTestImpl(),
                new FinancialDataRespositoryTestImpl(),
                new FinancialDataMapper(
                        LocalDateTime.of(2024,1,1,1,1,1)
                )
        );
        when(companyFacade.findCompanyByKrsIfNotExistInDbFetchAndSave("00000001")).thenReturn(
            CompanyResponseDto.builder()
                    .name("JEDEN SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ")
                    .KRSnumber("00000001")
                    .legalForm("SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ")
                    .build()
        );

    }

    @Test
    void should_return_correct_financial_data_from_remote_server(){

        final FinancialDataResponseDto financialDataResponseDto = financialDataFacade.fetchFinancialDataByKrs("00000001");
        assertAll(
                () -> assertEquals("JEDEN SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ", financialDataResponseDto.companyName()),
                () -> assertEquals("00000001", financialDataResponseDto.krsNumber()),
                () -> assertEquals("134.3", financialDataResponseDto.netSalesPercentageChange()),
                () -> assertEquals("230.3", financialDataResponseDto.ebitdaChangePercentageChange()),
                () -> assertEquals("227.2", financialDataResponseDto.netProfitOrLossPercentageChange()),
                () -> assertEquals("111.6", financialDataResponseDto.liabilitedAndProvisionsPercentageChange()),
                () -> assertEquals("339.5", financialDataResponseDto.equityPercentageChange()),
                () -> assertEquals("181.4", financialDataResponseDto.totalAssetsPercentageChange()),
                () -> assertEquals(LocalDateTime.of(2024, 1, 1, 1, 1, 1), financialDataResponseDto.fetchDate())
        );
    }
}
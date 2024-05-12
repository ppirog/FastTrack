package org.fasttrack.domain.creditreport;

import org.fasttrack.domain.company.CompanyFacade;
import org.fasttrack.domain.company.dto.CompanyResponseDto;
import org.fasttrack.domain.creditreport.dto.CreditReportResponseDto;
import org.fasttrack.domain.financialdata.FinancialDataFacade;
import org.fasttrack.domain.financialdata.dto.FinancialDataResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CreditReportFacadeTest {
    private final FinancialDataFacade financialDataFacade = mock(FinancialDataFacade.class);
    private final CompanyFacade companyFacade = mock(CompanyFacade.class);
    private CreditReportFacade creditReportFacade;

    @BeforeEach
    void setUp() {
        when(companyFacade.findCompanyByKrsIfNotExistInDbFetchAndSave("00000001")).thenReturn(
                CompanyResponseDto.builder()
                        .name("JEDEN SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ")
                        .KRSnumber("00000001")
                        .legalForm("SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ")
                        .build()
        );
        when(financialDataFacade.fetchFinancialDataByKrs("00000001")).thenReturn(
                FinancialDataResponseDto.builder()
                        .companyName("JEDEN SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ")
                        .krsNumber("00000001")
                        .fetchDate(LocalDateTime.of(2024, 1, 1, 1, 1, 1))
                        .netSalesValues(
                                List.of("12",
                                        "11",
                                        "10")
                        )
                        .ebitdaValues(
                                List.of("1.2",
                                        "1.1",
                                        "1")
                        )
                        .netProfitOrLossValues(
                                List.of("1.2",
                                        "1.1",
                                        "1")
                        )
                        .liabilitesAndProvisionsValues(
                                List.of(
                                        "10.0",
                                        "20.0",
                                        "30.0"
                                ))
                        .equityValues(
                                List.of(
                                        "70.0",
                                        "60.0",
                                        "50.0"
                                ))
                        .totalAssetsValues(
                                List.of(
                                        "80.0",
                                        "70.0",
                                        "60.0"
                                ))
                        .build()
        );
        creditReportFacade = new CreditReportFacade(financialDataFacade, new CreditReportCalculator(), new CreditReportMapper(), new CreditReportRepositoryTestImpl());

    }

    @Test
    void should_return_correct_report_when_company_financial_data_are_perfect() {

        final CreditReportResponseDto krs = creditReportFacade.fetchCreditReportByKrs("00000001");
        assertAll(
                () -> assertEquals("00000001",krs.krsNumber()),
                () -> assertEquals("JEDEN SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ",krs.comapnyName()),
                () -> assertEquals(100,krs.percentageScore()),
                () -> assertEquals(List.of(),krs.descriptions())
        );
    }
}
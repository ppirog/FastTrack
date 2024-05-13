package org.fasttrack.domain.creditreport;

import org.fasttrack.domain.company.CompanyFacade;
import org.fasttrack.domain.company.dto.CompanyResponseDto;
import org.fasttrack.domain.creditreport.dto.CreditReportResponseDto;
import org.fasttrack.domain.financialdata.FinancialDataFacade;
import org.fasttrack.domain.financialdata.dto.FinancialDataResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

        when(companyFacade.findCompanyByKrsIfNotExistInDbFetchAndSave("00000002")).thenReturn(
                CompanyResponseDto.builder()
                        .name("DWA SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ")
                        .KRSnumber("00000002")
                        .legalForm("SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ")
                        .build()
        );
        when(financialDataFacade.fetchFinancialDataByKrs("00000002")).thenReturn(
                FinancialDataResponseDto.builder()
                        .companyName("DWA SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ")
                        .krsNumber("00000002")
                        .fetchDate(LocalDateTime.of(2024, 1, 1, 1, 1, 1))
                        .netSalesValues(
                                List.of()
                        )
                        .ebitdaValues(
                                List.of("-1.2",
                                        "-1.1",
                                        "-1")
                        )
                        .netProfitOrLossValues(
                                List.of("-1.2",
                                        "-1.1",
                                        "-1")
                        )
                        .liabilitesAndProvisionsValues(
                                List.of(
                                        "120.0",
                                        "110.0",
                                        "100.0"
                                ))
                        .equityValues(
                                List.of(
                                        "-15.0",
                                        "-14.0",
                                        "-13.0"
                                ))
                        .totalAssetsValues(
                                List.of(
                                        "-80.0",
                                        "-75.0",
                                        "-86.0"
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

    @Test
    void should_return_correct_report_when_company_financial_data_are_the_worst() {

        final CreditReportResponseDto krs = creditReportFacade.fetchCreditReportByKrs("00000002");
        assertAll(
                () -> assertEquals("00000002",krs.krsNumber()),
                () -> assertEquals("DWA SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ",krs.comapnyName()),
                () -> assertEquals(4,krs.percentageScore()),
                () -> assertEquals(Set.of(
                        "EBITDA values are negative",
                        "EBITDA changes are negative",
                        "Net profit values are negative",
                        "Net profit changes are negative",
                        "Liaibilities are higher than 50% of assets",
                        "Liabilities are increasing",
                        "Assets values are negative",
                        "Assets changes are negative",
                        "Equity changes are negative",
                        "Equity values are negative"

                ), new HashSet<>(krs.descriptions()))
        );
    }
}
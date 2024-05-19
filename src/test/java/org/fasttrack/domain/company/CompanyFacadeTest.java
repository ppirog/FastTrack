package org.fasttrack.domain.company;

import org.fasttrack.domain.company.dto.CompanyResponseDto;
import org.fasttrack.domain.company.exceptions.NotFoundInDatabaseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CompanyFacadeTest {

    private CompanyFacade companyFacade;

    @BeforeEach
    void setUp() {
        companyFacade = new CompanyFacade(
                new CompanyRepositoryTestImpl(
                        List.of(
                                new Company(1L, "JEDEN SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ", "SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ", "00000001"),
                                new Company(2L, "DWA SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ", "SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ", "00000002"),
                                new Company(3L, "TRZY SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ", "SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ", "00000003"),
                                new Company(4L, "CZTERY SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ", "SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ", "00000004"),
                                new Company(5L, "PIEC SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ", "SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ", "00000005"),
                                new Company(6L, "SZESC SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ", "SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ", "00000006"),
                                new Company(7L, "SIEDEM SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ", "SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ", "00000007"),
                                new Company(8L, "OSIEM SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ", "SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ", "00000008"),
                                new Company(9L, "DZIEWIEC SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ", "SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ", "00000009"),
                                new Company(10L, "DZIESIEC SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ", "SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ", "00000010")
                        )
                ),
                new CompanyMapper(),
                new CompanyFetcherTestImpl()
        );
    }

    @Test
    void findAllCompanies() {
        assertEquals(10, companyFacade.findAll().size());
    }


    @Test
    void fetchCompanyByKrsAndSaveInDatabase() {

        final List<CompanyResponseDto> all1 = companyFacade.findAll();

        final CompanyResponseDto responseDto = companyFacade.findCompanyByKrsIfNotExistInDbFetchAndSave("00000051");

        final List<CompanyResponseDto> all2 = companyFacade.findAll();

        assertAll(
                () -> assertEquals(10, all1.size()),
                () -> assertEquals(11, all2.size()),
                () -> assertEquals("00000051", responseDto.KRSnumber()),
                () -> assertEquals("SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ", responseDto.legalForm()),
                () -> assertEquals("JEDEN FROM SERVER SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ", responseDto.name())
        );

    }


    @ParameterizedTest(name = "Find company by name: {0}")
    @ValueSource(strings = {
            "JEDEN SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ",
            "DWA SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ",
            "TRZY SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ",
            "CZTERY SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ",
            "PIEC SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ",
            "SZESC SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ",
            "SIEDEM SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ",
            "OSIEM SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ",
            "DZIEWIEC SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ",
            "DZIESIEC SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ"
    })
    void findCompanyByName(String name) {
        final CompanyResponseDto companyByName = companyFacade.findCompanyByName(name);
        assertEquals(name, companyByName.name());
    }


    @ParameterizedTest(name = "Find company by KRS number: {0}")
    @ValueSource(strings = {
            "00000001",
            "00000002",
            "00000003",
            "00000004",
            "00000005",
            "00000006",
            "00000007",
            "00000008",
            "00000009",
            "00000010"
    })
    void findCompanyByKRSnumber(String KRSnumber) {
        final CompanyResponseDto companyByKrs = companyFacade.findCompanyByKrsIfNotExistInDbFetchAndSave(KRSnumber);
        assertEquals(KRSnumber, companyByKrs.KRSnumber());
    }


    @ParameterizedTest(name = "Find company by KRS number: {0}")
    @ValueSource(strings = {
            "10000001",
            "10000002",
            "10000003",
            "10000004",
            "10000005",
            "10000006",
            "10000007",
            "10000008",
            "10000009",
            "10000010"
    })
    void shouldThrowNotFoundInDatabaseException(String krs) {
        assertThrows(NotFoundInDatabaseException.class, () -> companyFacade.findCompanyByKrs(krs));
    }

}
package org.fasttrack.infrastrucutre.financialdata.webscrap;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompanyNameStringParserTest {

    CompanyNameStringParser stringParser;

    @BeforeEach
    void setUp() {
        stringParser = new CompanyNameStringParser();
    }

    @ParameterizedTest(name = "CompanyNameStringParser")
    @CsvSource({
            "INNA FIRMA, inna-firma",
            "ą, a",
            "ąćęłńóśź   ż, acelnosz---z",
            "ĄĆĘŁŃÓŚ\\\"Ź   Ż, acelnosz---z",
            "MIKROBIT SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ, mikrobit-spolka-z-ograniczona-odpowiedzialnoscia",
            "QODECA SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ, qodeca-spolka-z-ograniczona-odpowiedzialnoscia",

    })
    public void testMethod(String input, String expected) {
        String result = stringParser.parseCompanyName(input);
        assertEquals(expected, result);
    }
}
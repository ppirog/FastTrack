package org.fasttrack;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import lombok.extern.log4j.Log4j2;
import org.fasttrack.domain.company.dto.CompanyResponseDto;
import org.fasttrack.domain.financialdata.dto.FinancialDataResponseDto;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@Testcontainers
@AutoConfigureMockMvc
@Log4j2
class FastTrackApplicationTests implements SampleCompanyResponse, SampleFinanialDataResponse {
    @Container
    private static final PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:latest");
    private static final String WIRE_MOCK_HOST = "http://localhost";

    @RegisterExtension
    public static WireMockExtension wireMockServer = WireMockExtension.newInstance()
            .options(wireMockConfig().dynamicPort())
            .build();

    @Autowired
    public ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @DynamicPropertySource
    static void postgreSQLProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
        registry.add("spring.datasource.password", postgreSQLContainer::getPassword);

        registry.add("krs.server.url", () -> WIRE_MOCK_HOST + ":" + wireMockServer.getPort());
        registry.add("jsoup.url", () -> WIRE_MOCK_HOST + ":" + wireMockServer.getPort() + "/");

    }

    @BeforeAll
    static void beforeAll() {
        postgreSQLContainer.start();
    }

    @AfterAll
    static void afterAll() {
        postgreSQLContainer.stop();
    }

    @Test
    void happy_path() throws Exception {

        wireMockServer.stubFor(
                WireMock.get("/api/krs/OdpisAktualny/0000121862?rejestr=P&format=json")
                        .willReturn(WireMock.aResponse()
                                .withStatus(HttpStatus.OK.value())
                                .withHeader("Content-Type", "application/json")
                                .withBody(
                                        getSampleCompanyResponse()
                                )));

        wireMockServer.stubFor(
                WireMock.get(urlEqualTo( "/kpmg-spolka-z-ograniczona-odpowiedzialnoscia"))
                        .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "text/html")
                                .withBody(geg())));


        final String content = mockMvc.perform(get("/company/0000121862"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        final CompanyResponseDto dto1 = objectMapper.readValue(content, CompanyResponseDto.class);

        assertAll(
                () -> Assertions.assertEquals("0000121862", dto1.KRSnumber()),
                () -> Assertions.assertEquals("SPOLKA Z OGRANICZONA ODPOWIEDZIALNOSCIA", dto1.legalForm()),
                () -> Assertions.assertEquals("KPMG SPOLKA Z OGRANICZONA ODPOWIEDZIALNOSCIA", dto1.name())
        );

        final String content2 = mockMvc.perform(get("/financialData/0000121862"))
                .andReturn().getResponse().getContentAsString();
        final FinancialDataResponseDto dto2 = objectMapper.readValue(content2, FinancialDataResponseDto.class);

        assertAll(
                () -> Assertions.assertEquals("0000121862", dto2.krsNumber()),
                () -> Assertions.assertEquals("KPMG SPOLKA Z OGRANICZONA ODPOWIEDZIALNOSCIA", dto2.companyName()),
                () -> Assertions.assertEquals(List.of("-0.5","0.1","-1.5"), dto2.ebitdaValues()),
                () -> Assertions.assertEquals(List.of(), dto2.netProfitOrLossValues()),
                () -> Assertions.assertEquals(List.of("56.7","54.6","52.7"), dto2.equityValues()),
                () -> Assertions.assertEquals(List.of("52.9","43.4","34.0"), dto2.liabilitesAndProvisionsValues()),
                () -> Assertions.assertEquals(List.of(), dto2.netSalesValues())
        );
    }

}

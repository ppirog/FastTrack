package org.fasttrack;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import lombok.extern.log4j.Log4j2;
import org.fasttrack.domain.company.dto.CompanyResponseDto;
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

import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static com.github.tomakehurst.wiremock.client.WireMock.*;

@SpringBootTest
@ActiveProfiles("test")
@Testcontainers
@AutoConfigureMockMvc
@Log4j2
class FastTrackApplicationTests implements SampleCompanyResponse {
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
    void contextLoads() throws Exception {

        wireMockServer.stubFor(
                WireMock.get("/api/krs/OdpisAktualny/0000121862?rejestr=P&format=json")
                        .willReturn(WireMock.aResponse()
                                .withStatus(HttpStatus.OK.value())
                                .withHeader("Content-Type", "application/json")
                                .withBody(
                        getSampleCompanyResponse()
                )));

        wireMockServer.stubFor(
                WireMock.get(urlEqualTo("/example-page"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "text/html")
                        .withBody("<html><head><title>Example Page</title></head><body><h1>Hello, world!</h1></body></html>")));

        final String content = mockMvc.perform(get("/company/0000121862"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        final CompanyResponseDto companyResponseDto = objectMapper.readValue(content, CompanyResponseDto.class);

        assertAll(
                () -> Assertions.assertEquals("0000121862", companyResponseDto.KRSnumber()),
                () -> Assertions.assertEquals("SPOLKA Z OGRANICZONA ODPOWIEDZIALNOSCIA", companyResponseDto.legalForm()),
                () -> Assertions.assertEquals("JEDEN SPOLKA Z OGRANICZONA ODPOWIEDZIALNOSCIA", companyResponseDto.name())
        );


    }

}

package org.fasttrack;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import lombok.extern.log4j.Log4j2;
import org.fasttrack.domain.company.CompanyFacade;
import org.fasttrack.infrastrucutre.errorvalidation.dto.DuplicateKeyExceptionDto;
import org.fasttrack.infrastrucutre.security.dto.JwtResponseDto;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.regex.Pattern;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Log4j2
@SpringBootTest
@ActiveProfiles("test")
@Testcontainers
@AutoConfigureMockMvc
class FastTrackApplicationIntegrationTests implements SampleCompanyResponse, SampleFinanialDataResponse {

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

    @Autowired
    private CompanyFacade companyFacade;

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

        /* step 1 user made POST request to /register endpoint with data someUser and somePassword and status is 201
         *  step 2 user made POST request to /register endpoint with data someUser and somePassword and status is 409, message = "Login already exists"
         *  step 3 user made POST request to /login endpoint with data someUser and somePassword and received status 200 with token
         *  step 4 user made GET request to /company/{krs} (no token) with 0000121862 and received status UNAUTHORIZED
         *  step 5 user made GET request to /company/{krs} (with token) with 0000121862 and received status 200 with response krs 0000121862, formaPrawna SPOLKA Z OGRANICZONA ODPOWIEDZIALNOSCIA, and companyName KPMG SPOLKA Z OGRANICZONA ODPOWIEDZIALNOSCIA
         *  step 6 user made GET request to /company/{krs} with 0000000000 and received status 404
         *  step 7 user made GET request to /financialData/{krs} (no token) with 0000121862 and received status UNAUTHORIZED
         *  step 8 user made GET request to /financialData/{krs} (with token) with 0000121862 and received financial data
         *  step 9 user made GET request to /creditReport/{krs} (no token) and received status UNAUTHORIZED
         *  step 10 user made GET request to /creditReport/{krs} (with token) and received credit report
         * */

        wireMockServer.stubFor(
                WireMock.get("/api/krs/OdpisAktualny/0000121862?rejestr=P&format=json")
                        .willReturn(WireMock.aResponse()
                                .withStatus(HttpStatus.OK.value())
                                .withHeader("Content-Type", "application/json")
                                .withBody(
                                        sampleCompanyFromKrsResponse()
                                )));

        wireMockServer.stubFor(
                WireMock.get(urlEqualTo("/kpmg-spolka-z-ograniczona-odpowiedzialnoscia"))
                        .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "text/html")
                                .withBody(sampleFinancialDataRepsonse())));


//        final String content = mockMvc.perform(get("/company/0000121862"))
//                .andExpect(status().isOk())
//                .andReturn().getResponse().getContentAsString();
//        final CompanyResponseDto dto1 = objectMapper.readValue(content, CompanyResponseDto.class);
//
//        assertAll(
//                () -> Assertions.assertEquals("0000121862", dto1.KRSnumber()),
//                () -> Assertions.assertEquals("SPOLKA Z OGRANICZONA ODPOWIEDZIALNOSCIA", dto1.legalForm()),
//                () -> Assertions.assertEquals("KPMG SPOLKA Z OGRANICZONA ODPOWIEDZIALNOSCIA", dto1.name())
//        );
//
//        final String content2 = mockMvc.perform(get("/financialData/0000121862"))
//                .andReturn().getResponse().getContentAsString();
//        final FinancialDataResponseDto dto2 = objectMapper.readValue(content2, FinancialDataResponseDto.class);
//
//        assertAll(
//                () -> Assertions.assertEquals("0000121862", dto2.krsNumber()),
//                () -> Assertions.assertEquals("KPMG SPOLKA Z OGRANICZONA ODPOWIEDZIALNOSCIA", dto2.companyName()),
//                () -> Assertions.assertEquals(List.of("-0.5", "0.1", "-1.5"), dto2.ebitdaValues()),
//                () -> Assertions.assertEquals(List.of(), dto2.netProfitOrLossValues()),
//                () -> Assertions.assertEquals(List.of("56.7", "54.6", "52.7"), dto2.equityValues()),
//                () -> Assertions.assertEquals(List.of("52.9", "43.4", "34.0"), dto2.liabilitesAndProvisionsValues()),
//                () -> Assertions.assertEquals(List.of(), dto2.netSalesValues()),
//                () -> Assertions.assertEquals(1, companyFacade.findAll().size())
//        );



        // step 1  user made POST request to /register endpoint with data someUser and somePassword and status is 201
        mockMvc.perform(post("/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                "username": "someUser",
                                "password": "somePassword"
                                }
                                """))
                .andExpect(status().isCreated());



        //step 2 user made POST request to /register endpoint with data someUser and somePassword and status is 409, message = "Login already exists"
        final MvcResult resultStep2 = mockMvc.perform(post("/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                "username": "someUser",
                                "password": "somePassword"
                                }
                                """))
                .andExpect(status().isConflict())
                .andReturn();

        final DuplicateKeyExceptionDto duplicateKeyExceptionDto = objectMapper.readValue(resultStep2.getResponse().getContentAsString(), DuplicateKeyExceptionDto.class);

        assertAll(
                () -> assertEquals(duplicateKeyExceptionDto.message(), "Login already exists")
        );



        // step 3 user made POST request to /login endpoint with data someUser and somePassword and received status 200 with token
        final MvcResult resultStep3 = mockMvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                "username": "someUser",
                                "password": "somePassword"
                                }
                                """))
                .andExpect(status().isOk())
                .andReturn();

        final JwtResponseDto jwtResponseDto = objectMapper.readValue(resultStep3.getResponse().getContentAsString(), JwtResponseDto.class);
        final String login = jwtResponseDto.login();
        final String token = jwtResponseDto.token();
        assertAll(
                () -> assertEquals(login,"someUser"),
                () -> assertThat(token).matches(Pattern.compile("^[A-Za-z0-9-_=]+\\.[A-Za-z0-9-_=]+\\.?[A-Za-z0-9-_.+/=]*$"))
        );

    }

}

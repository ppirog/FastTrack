package org.fasttrack;

import lombok.extern.log4j.Log4j2;
import org.fasttrack.domain.company.CompanyFetchable;
import org.fasttrack.infrastrucutre.financialdata.webscrap.CompanyNameStringParser;
import org.fasttrack.infrastrucutre.financialdata.webscrap.FinancialDataFetchableJsoupAleo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableFeignClients
@Log4j2
public class FastTrackApplication {

    @Autowired
    private CompanyFetchable companyFetchable;

    public static void main(String[] args) {
        SpringApplication.run(FastTrackApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void fetchCompany() {
        FinancialDataFetchableJsoupAleo jsoupAleo = new FinancialDataFetchableJsoupAleo(
                new CompanyNameStringParser()
        );

        log.warn(jsoupAleo.fetchFinancialDataByCompanyName(
                "QODECA SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ"));
    }
}

package org.fasttrack;

import feign.FeignException;
import lombok.extern.log4j.Log4j2;
import org.fasttrack.domain.company.CompanyFetchable;
import org.fasttrack.domain.company.dto.server.CompanyResponseFromServerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

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
        try {
            CompanyResponseFromServerDto fetch = companyFetchable.fetch("00007493990");
        }
        catch (FeignException.FeignClientException feignClientException) {
            log.error("Company not found in external server: {}", feignClientException.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found in external server", feignClientException);
        }
        catch (FeignException feignException) {
            log.error("Error fetching company data from external server: {}", feignException.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", feignException);
        }
    }
}

package org.fasttrack;

import lombok.extern.log4j.Log4j2;
import org.fasttrack.domain.company.CompanyFetchable;
import org.fasttrack.domain.company.dto.server.CompanyResponseFromServerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableFeignClients
public class FastTrackApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastTrackApplication.class, args);
    }

}

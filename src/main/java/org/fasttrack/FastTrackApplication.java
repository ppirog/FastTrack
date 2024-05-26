package org.fasttrack;

import lombok.extern.log4j.Log4j2;
import org.fasttrack.infrastrucutre.financialdata.webscrap.JSoupConfigurationProperties;
import org.fasttrack.infrastrucutre.security.JwtConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@Log4j2
@EnableConfigurationProperties(value = {JSoupConfigurationProperties.class, JwtConfigProperties.class})
public class FastTrackApplication {
    public static void main(String[] args) {
        SpringApplication.run(FastTrackApplication.class, args);
    }
}
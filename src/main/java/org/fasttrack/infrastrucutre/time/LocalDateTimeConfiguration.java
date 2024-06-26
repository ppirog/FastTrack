package org.fasttrack.infrastrucutre.time;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;
import java.time.LocalDateTime;

@Configuration
class LocalDateTimeConfiguration {

    @Bean
    public LocalDateTime dateTime(){
        return LocalDateTime.now();
    }
    @Bean
    public Clock clock(){
        return Clock.systemUTC();
    }

}

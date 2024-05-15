package org.fasttrack.infrastrucutre.financialdata.webscrap;

import org.springframework.boot.context.properties.ConfigurationProperties;



@ConfigurationProperties(value = "jsoup")
public record JSoupConfigurationProperties(
        String url
) {
}

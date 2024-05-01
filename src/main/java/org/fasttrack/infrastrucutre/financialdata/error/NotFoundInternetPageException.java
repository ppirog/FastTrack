package org.fasttrack.infrastrucutre.financialdata.error;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public record NotFoundInternetPageException(
        HttpStatus status,
        String message
) {
}

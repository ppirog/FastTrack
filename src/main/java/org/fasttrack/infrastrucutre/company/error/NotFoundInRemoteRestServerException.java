package org.fasttrack.infrastrucutre.company.error;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public record NotFoundInRemoteRestServerException(
        HttpStatus status,
        String message
) {
}

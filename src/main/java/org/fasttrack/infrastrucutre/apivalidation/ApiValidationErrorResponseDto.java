package org.fasttrack.infrastrucutre.apivalidation;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.util.List;
@Builder
public record ApiValidationErrorResponseDto(
        List<String> errors,
        HttpStatus status
) {
}

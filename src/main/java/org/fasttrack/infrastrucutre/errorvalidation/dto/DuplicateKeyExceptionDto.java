package org.fasttrack.infrastrucutre.errorvalidation.dto;

import lombok.Builder;

@Builder
public record DuplicateKeyExceptionDto(
        String message
) {
}

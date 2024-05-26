package org.fasttrack.infrastrucutre.loginandregister.controller.dto;

import lombok.Builder;

@Builder
public record RegisterResponseDto(
        String username,
        String message
) {
}

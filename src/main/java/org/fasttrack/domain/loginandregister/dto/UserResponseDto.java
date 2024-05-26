package org.fasttrack.domain.loginandregister.dto;

import lombok.Builder;

@Builder
public record UserResponseDto(
        String username,
        String password,
        String message
) {
}

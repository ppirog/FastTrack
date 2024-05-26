package org.fasttrack.infrastrucutre.security.dto;

import lombok.Builder;

@Builder
public record JwtResponseDto(
        String login,
        String token
) {
}

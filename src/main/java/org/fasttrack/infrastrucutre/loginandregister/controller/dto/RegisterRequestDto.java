package org.fasttrack.infrastrucutre.loginandregister.controller.dto;

import lombok.Builder;

@Builder
public record RegisterRequestDto(
        String username,
        String password
) {
}

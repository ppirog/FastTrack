package org.fasttrack.infrastrucutre.security.dto;

import lombok.Builder;

@Builder
public record TokenRequestDto(

        String username,

        String password
) {
}

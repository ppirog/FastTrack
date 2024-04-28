package org.fasttrack.domain.company.dto;

import lombok.Builder;

@Builder
public record CompanyResponseDto(
        Long id,
        String name,
        String legalForm,
        String KRSnumber
) {
}

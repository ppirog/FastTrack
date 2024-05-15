package org.fasttrack.domain.company.dto;

import lombok.Builder;

@Builder
public record CompanyRequestDto(
        String name,
        String legalForm,
        String KRSnumber
) {
}

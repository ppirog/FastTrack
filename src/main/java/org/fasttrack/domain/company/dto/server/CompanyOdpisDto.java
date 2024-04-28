package org.fasttrack.domain.company.dto.server;

import lombok.Builder;

@Builder
public record CompanyOdpisDto(
        CompanyNaglowekADto naglowekA,
        CompanyDaneDto dane
) {
}

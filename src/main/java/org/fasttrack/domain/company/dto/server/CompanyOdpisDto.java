package org.fasttrack.domain.company.dto.server;

import lombok.Builder;

@Builder
record CompanyOdpisDto(
        CompanyNaglowekADto naglowekA,
        CompanyDaneDto dane
) {
}

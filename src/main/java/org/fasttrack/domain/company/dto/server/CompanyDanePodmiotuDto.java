package org.fasttrack.domain.company.dto.server;

import lombok.Builder;

@Builder
public record CompanyDanePodmiotuDto(
        String formaPrawna,
        String nazwa
) {
}

package org.fasttrack.domain.company.dto.server;

import lombok.Builder;

@Builder
public record CompanyResponseFromServerDto(
        CompanyOdpisDto odpis
) {
}

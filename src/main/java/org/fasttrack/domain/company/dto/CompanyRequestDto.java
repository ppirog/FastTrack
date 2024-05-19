package org.fasttrack.domain.company.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record CompanyRequestDto(
        @NotNull(message = "{name.not.null}")
        @NotBlank(message = "{name.not.blank}")
        String name,
        @NotNull(message = "{legalForm.not.null}")
        @NotBlank(message = "{legalForm.not.blank}")
        String legalForm,
        @NotNull(message = "{KRSnumber.not.null}")
        @NotBlank(message = "{KRSnumber.not.blank}")
        String KRSnumber
) {
}

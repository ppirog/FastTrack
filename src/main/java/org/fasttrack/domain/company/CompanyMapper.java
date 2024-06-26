package org.fasttrack.domain.company;

import lombok.AllArgsConstructor;
import org.fasttrack.domain.company.dto.CompanyRequestDto;
import org.fasttrack.domain.company.dto.CompanyResponseDto;
import org.fasttrack.domain.company.dto.server.CompanyResponseFromServerDto;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
class CompanyMapper {

    public Company toCompany(CompanyResponseFromServerDto companyResponseFromServerDto) {
        return Company.builder()
                .name(companyResponseFromServerDto.odpis().dane().dzial1().danePodmiotu().nazwa())
                .legalForm(companyResponseFromServerDto.odpis().dane().dzial1().danePodmiotu().formaPrawna())
                .KRSnumber(companyResponseFromServerDto.odpis().naglowekA().numerKRS())
                .build();
    }

    public CompanyResponseDto toCompanyResponseDto(Company company) {
        return CompanyResponseDto.builder()
                .id(company.getId())
                .name(company.getName())
                .legalForm(company.getLegalForm())
                .KRSnumber(company.getKRSnumber())
                .build();
    }


    public Company toCompanyFromRequest(CompanyRequestDto companyRequestDto) {
        return Company.builder()
                .name(companyRequestDto.name())
                .legalForm(companyRequestDto.legalForm())
                .KRSnumber(companyRequestDto.KRSnumber())
                .build();
    }
}
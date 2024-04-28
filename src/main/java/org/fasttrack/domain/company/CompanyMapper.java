package org.fasttrack.domain.company;

import lombok.AllArgsConstructor;
import org.fasttrack.domain.company.dto.CompanyResponseDto;
import org.fasttrack.domain.company.dto.server.CompanyResponseFromServerDto;

@AllArgsConstructor
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
}
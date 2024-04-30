package org.fasttrack.domain.company;

import org.fasttrack.domain.company.dto.server.CompanyDaneDto;
import org.fasttrack.domain.company.dto.server.CompanyDanePodmiotuDto;
import org.fasttrack.domain.company.dto.server.CompanyDzial1Dto;
import org.fasttrack.domain.company.dto.server.CompanyNaglowekADto;
import org.fasttrack.domain.company.dto.server.CompanyOdpisDto;
import org.fasttrack.domain.company.dto.server.CompanyResponseFromServerDto;

class CompanyFetcherTestImpl implements CompanyFetchable {

    @Override
    public CompanyResponseFromServerDto fetch(final String krs) {
        return CompanyResponseFromServerDto.builder()
                .odpis(CompanyOdpisDto.builder()
                        .naglowekA(CompanyNaglowekADto.builder()
                                .numerKRS(krs)
                                .build())
                        .dane(CompanyDaneDto.builder()
                                .dzial1(CompanyDzial1Dto.builder()
                                        .danePodmiotu(
                                                CompanyDanePodmiotuDto.builder()
                                                        .formaPrawna("SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ")
                                                        .nazwa("JEDEN FROM SERVER SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ")
                                                        .build()
                                        )
                                        .build())
                                .build())
                        .build())
                .build();
    }
}

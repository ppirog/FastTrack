package org.fasttrack.domain.company;

import org.fasttrack.domain.company.dto.server.CompanyDaneDto;
import org.fasttrack.domain.company.dto.server.CompanyDanePodmiotuDto;
import org.fasttrack.domain.company.dto.server.CompanyDzial1Dto;
import org.fasttrack.domain.company.dto.server.CompanyNaglowekADto;
import org.fasttrack.domain.company.dto.server.CompanyOdpisDto;
import org.fasttrack.domain.company.dto.server.CompanyResponseFromServerDto;

import java.util.HashMap;

class CompanyFetcherTestImpl implements CompanyFetchable {

    private final HashMap<String, CompanyResponseFromServerDto> database = new HashMap<>();
    {
        final CompanyResponseFromServerDto fromServerDto1 = CompanyResponseFromServerDto.builder()
                .odpis(CompanyOdpisDto.builder()
                        .naglowekA(CompanyNaglowekADto.builder()
                                .numerKRS("00000000")
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
        database.put("00000000",fromServerDto1);

        final CompanyResponseFromServerDto fromServerDto2 = CompanyResponseFromServerDto.builder()
                .odpis(CompanyOdpisDto.builder()
                        .naglowekA(CompanyNaglowekADto.builder()
                                .numerKRS("00000002")
                                .build())
                        .dane(CompanyDaneDto.builder()
                                .dzial1(CompanyDzial1Dto.builder()
                                        .danePodmiotu(
                                                CompanyDanePodmiotuDto.builder()
                                                        .formaPrawna("SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ")
                                                        .nazwa("DWA FROM SERVER SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ")
                                                        .build()
                                        )
                                        .build())
                                .build())
                        .build())
                .build();
        database.put("00000002",fromServerDto2);

        final CompanyResponseFromServerDto fromServerDto3 = CompanyResponseFromServerDto.builder()
                .odpis(CompanyOdpisDto.builder()
                        .naglowekA(CompanyNaglowekADto.builder()
                                .numerKRS("00000002")
                                .build())
                        .dane(CompanyDaneDto.builder()
                                .dzial1(CompanyDzial1Dto.builder()
                                        .danePodmiotu(
                                                CompanyDanePodmiotuDto.builder()
                                                        .formaPrawna("SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ")
                                                        .nazwa("TRZy FROM SERVER SPÓŁKA Z OGRANICZONĄ ODPOWIEDZIALNOŚCIĄ")
                                                        .build()
                                        )
                                        .build())
                                .build())
                        .build())
                .build();
        database.put("00000003",fromServerDto3);
    }

    @Override
    public CompanyResponseFromServerDto fetch(final String krs) {
        return database.get(krs);
    }
}

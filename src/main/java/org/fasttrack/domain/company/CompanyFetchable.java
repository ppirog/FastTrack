package org.fasttrack.domain.company;

import org.fasttrack.domain.company.dto.server.CompanyResponseFromServerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "krsClient", url = "https://api-krs.ms.gov.pl")
public interface CompanyFetchable {

    //https://api-krs.ms.gov.pl/api/krs/OdpisAktualny/0000793990?rejestr=P&format=json

    @GetMapping("/api/krs/OdpisAktualny/{krs}?rejestr=P&format=json")
    CompanyResponseFromServerDto fetch(@PathVariable String krs);

}

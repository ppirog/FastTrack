package org.fasttrack.infrastrucutre.company.controller;

import lombok.AllArgsConstructor;
import org.fasttrack.domain.company.CompanyFacade;
import org.fasttrack.domain.company.dto.CompanyRequestDto;
import org.fasttrack.domain.company.dto.CompanyResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/company" )
public class CompanyRestController {
    private final CompanyFacade companyFacade;

    @GetMapping("/{krs}")
    public ResponseEntity<CompanyResponseDto> findOfferById(@PathVariable String krs) {
        return ResponseEntity.ok(companyFacade.findCompanyByKrsIfNotExistInDbFetchAndSave(krs));
    }

    @PostMapping
    public ResponseEntity<CompanyResponseDto> findOfferByName(@RequestBody CompanyRequestDto dto) {
        return ResponseEntity.ok(companyFacade.saveCompany(dto));
    }

    


}

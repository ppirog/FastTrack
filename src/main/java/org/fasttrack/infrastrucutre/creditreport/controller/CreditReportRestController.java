package org.fasttrack.infrastrucutre.creditreport.controller;

import lombok.AllArgsConstructor;
import org.fasttrack.domain.creditreport.CreditReportFacade;
import org.fasttrack.domain.creditreport.dto.CreditReportResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/creditReport" )
public class CreditReportRestController {

    private final CreditReportFacade creditReportFacade;

    @GetMapping("/{krs}")
    public ResponseEntity<CreditReportResponseDto> fetchCreditReportByKrs(@PathVariable String krs) {
        return ResponseEntity.ok(creditReportFacade.fetchCreditReportByKrs(krs));
    }
}

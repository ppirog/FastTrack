package org.fasttrack.infrastrucutre.creditreport.controller;

import lombok.AllArgsConstructor;
import org.fasttrack.domain.creditreport.CreditReportFacade;
import org.fasttrack.domain.creditreport.dto.CreditReportResponseDto;
import org.fasttrack.infrastrucutre.creditreport.dto.DeleteCreditReportResponseDto;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/creditReport" )
public class CreditReportRestController {

    private final CreditReportFacade creditReportFacade;

    @GetMapping("/{krs}")
    public ResponseEntity<CreditReportResponseDto> fetchCreditReportByKrs(@PathVariable String krs) {
        return ResponseEntity.ok(creditReportFacade.fetchCreditReportByKrs(krs));
    }

    @GetMapping
    public ResponseEntity<List<CreditReportResponseDto>> fetchAllCreditReports(@PageableDefault(size = 5) Pageable pageable) {
        return ResponseEntity.ok(creditReportFacade.fetchAllCreditReports(pageable));
    }

    @DeleteMapping("/{krs}")
    public ResponseEntity<DeleteCreditReportResponseDto> deleteCreditReportByKrs(@PathVariable String krs) {
        return ResponseEntity.ok(creditReportFacade.deleteCreditReportByKrs(krs));
    }
}

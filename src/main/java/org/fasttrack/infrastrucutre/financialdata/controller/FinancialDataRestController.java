package org.fasttrack.infrastrucutre.financialdata.controller;

import lombok.AllArgsConstructor;
import org.fasttrack.domain.financialdata.FinancialDataFacade;
import org.fasttrack.domain.financialdata.dto.FinancialDataResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/financialData" )
public class FinancialDataRestController {

    private final FinancialDataFacade financialDataFacade;

    @GetMapping("/{krs}")
    public ResponseEntity<FinancialDataResponseDto> findOfferById(@PathVariable String krs) {
        return ResponseEntity.ok(financialDataFacade.fetchFinancialDataByKrs(krs));
    }
}

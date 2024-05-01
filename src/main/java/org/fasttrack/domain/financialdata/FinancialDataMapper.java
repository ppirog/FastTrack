package org.fasttrack.domain.financialdata;

import lombok.AllArgsConstructor;
import org.fasttrack.domain.financialdata.dto.FinancialDataResponseDto;
import org.fasttrack.domain.financialdata.dto.server.FinancialDataResponseFromServerDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@AllArgsConstructor
class FinancialDataMapper {

    private final LocalDateTime dateTime;

    public FinancialData toEntity(FinancialDataResponseFromServerDto dto){
        return FinancialData.builder()
                .fetchDate(dateTime)
                .comapnyName(dto.companyName())
                .krsNumber(dto.krsNumber())
                .netSalesPercentageChange(Double.valueOf(dto.netSalesPercentageChange()))
                .ebitdaPercentageChange(Double.valueOf(dto.ebitdaChangePercentageChange()))
                .netProfitOrLossPercentageChange(Double.valueOf(dto.netProfitOrLossPercentageChange()))
                .liabilitesAndProvisionsPercentageChange(Double.valueOf(dto.liabilitedAndProvisionsPercentageChange()))
                .equityPercentageChange(Double.valueOf(dto.equityPercentageChange()))
                .totalAssetsPercentageChange(Double.valueOf(dto.totalAssetsPercentageChange()))
                .build();

        
    }

    public FinancialDataResponseDto toDto(FinancialData entity){
        return FinancialDataResponseDto.builder()
                .fetchDate(entity.getFetchDate())
                .krsNumber(entity.getKrsNumber())
                .companyName(entity.getComapnyName())
                .netSalesPercentageChange(String.valueOf(entity.getNetSalesPercentageChange()))
                .ebitdaChangePercentageChange(String.valueOf(entity.getEbitdaPercentageChange()))
                .netProfitOrLossPercentageChange(String.valueOf(entity.getNetProfitOrLossPercentageChange()))
                .liabilitedAndProvisionsPercentageChange(String.valueOf(entity.getLiabilitesAndProvisionsPercentageChange()))
                .equityPercentageChange(String.valueOf(entity.getEquityPercentageChange()))
                .totalAssetsPercentageChange(String.valueOf(entity.getTotalAssetsPercentageChange()))
                .build();
    }
}

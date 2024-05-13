package org.fasttrack.domain.financialdata;

import lombok.AllArgsConstructor;
import org.fasttrack.domain.financialdata.dto.FinancialDataResponseDto;
import org.fasttrack.domain.financialdata.dto.server.FinancialDataResponseFromServerDto;

import java.time.LocalDateTime;

@AllArgsConstructor
class FinancialDataMapper {

    private final LocalDateTime dateTime;

    public FinancialData toEntity(FinancialDataResponseFromServerDto dto){


        return FinancialData.builder()
                .fetchDate(dateTime)
                .comapnyName(dto.companyName())
                .krsNumber(dto.krsNumber())
                .netSalesValues(dto.netSalesPercentageChange().stream().map(Double::valueOf).toList())
                .ebitdaValues(dto.ebitdaChangePercentageChange().stream().map(Double::valueOf).toList())
                .netProfitOrLossValues(dto.netProfitOrLossPercentageChange().stream().map(Double::valueOf).toList())
                .liabilitesAndProvisionsValues(dto.liabilitedAndProvisionsPercentageChange().stream().map(Double::valueOf).toList())
                .equityValues(dto.equityPercentageChange().stream().map(Double::valueOf).toList())
                .totalAssetsValues(dto.totalAssetsPercentageChange().stream().map(Double::valueOf).toList()
                )
                .build();

        
    }

    public FinancialDataResponseDto toDto(FinancialData entity){

        return FinancialDataResponseDto.builder()
                .fetchDate(entity.getFetchDate())
                .krsNumber(entity.getKrsNumber())
                .companyName(entity.getComapnyName())
                .netSalesValues(entity.getNetSalesValues().stream().map(String::valueOf).toList())
                .ebitdaValues(entity.getEbitdaValues().stream().map(String::valueOf).toList())
                .netProfitOrLossValues(entity.getNetProfitOrLossValues().stream().map(String::valueOf).toList())
                .liabilitesAndProvisionsValues(entity.getLiabilitesAndProvisionsValues().stream().map(String::valueOf).toList())
                .equityValues(entity.getEquityValues().stream().map(String::valueOf).toList())
                .totalAssetsValues(entity.getTotalAssetsValues().stream().map(String::valueOf).toList())
                .build();
    }
}

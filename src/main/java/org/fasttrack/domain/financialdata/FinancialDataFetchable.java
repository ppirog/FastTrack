package org.fasttrack.domain.financialdata;

import org.fasttrack.domain.financialdata.dto.server.FinancialDataResponseFromServerDto;

import java.util.Optional;

public interface FinancialDataFetchable {

    Optional<FinancialDataResponseFromServerDto> fetchFinancialDataByCompanyName(String name);
}

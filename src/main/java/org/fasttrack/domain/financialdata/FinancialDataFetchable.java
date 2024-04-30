package org.fasttrack.domain.financialdata;

import org.fasttrack.domain.financialdata.dto.server.FinancialDataResponseFromServerDto;

public interface FinancialDataFetchable {

    FinancialDataResponseFromServerDto fetchFinancialDataByCompanyName(String name);
}

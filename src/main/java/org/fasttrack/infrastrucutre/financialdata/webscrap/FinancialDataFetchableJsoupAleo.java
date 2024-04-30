package org.fasttrack.infrastrucutre.financialdata.webscrap;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fasttrack.domain.financialdata.FinancialDataFetchable;
import org.fasttrack.domain.financialdata.dto.server.FinancialDataResponseFromServerDto;

@AllArgsConstructor
@Log4j2
public class FinancialDataFetchableJsoupAleo implements FinancialDataFetchable {


    @Override
    public FinancialDataResponseFromServerDto fetchFinancialDataByCompanyName(final String name) {
        return null;
    }
}

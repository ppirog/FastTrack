package org.fasttrack.domain.financialdata;


import java.util.List;
import java.util.Optional;

interface FinancialDataRepository {
    FinancialData save(FinancialData financialData);
    Optional<FinancialData> findById(Long id);
    Optional<FinancialData> findByName(String name);
    Optional<FinancialData> findByKRSnumber(String KRSnumber);
    List<FinancialData> findAll();
    void delete(Long id);
}

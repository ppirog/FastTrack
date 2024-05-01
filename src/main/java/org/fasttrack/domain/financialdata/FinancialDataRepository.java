package org.fasttrack.domain.financialdata;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface FinancialDataRepository extends JpaRepository<FinancialData,Long> {
    FinancialData save(FinancialData financialData);
    Optional<FinancialData> findById(Long id);
    Optional<FinancialData> findByComapnyName(String name);
    List<FinancialData> findByKrsNumberOrderByFetchDateDesc(String KRSnumber);
    List<FinancialData> findAll();
    void deleteById(Long id);
}

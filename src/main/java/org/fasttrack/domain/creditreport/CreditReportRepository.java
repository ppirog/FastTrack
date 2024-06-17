package org.fasttrack.domain.creditreport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CreditReportRepository extends JpaRepository<CreditReport, Long> {
    List<CreditReport> findByKrsNumber(String krsNumber);

    @Transactional
    @Modifying
    long deleteByKrsNumber(String krsNumber);
}
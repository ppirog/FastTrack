package org.fasttrack.domain.creditreport;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CreditReportRepository extends JpaRepository<CreditReport, Long> {
    List<CreditReport> findByKrsNumber(String krsNumber);
}
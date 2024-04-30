package org.fasttrack.domain.financialdata;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Entity
@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
class FinancialData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private LocalDateTime fetchDate;

    @Column(nullable = false)
    private String krsNumber;

    @Column(nullable = false)
    private String comapnyName;

    private Double netSalesPercentageChange;
    private Double ebitdaPercentageChange;
    private Double netProfitOrLossPercentageChange;
    private Double liabilitesAndProvisionsPercentageChange;
    private Double equityPercentageChange;
    private Double totalAssetsPercentageChange;


}

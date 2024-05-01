package org.fasttrack.domain.financialdata;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Builder
@Entity
@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Table(name = "financial_data")
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


    public boolean areEqualDataExceptFetchDateAndId(FinancialData f1) {
        if (this == f1) return true;
        if (f1 == null || getClass() != f1.getClass()) return false;

        return Objects.equals(krsNumber, f1.krsNumber) &&
                Objects.equals(comapnyName, f1.comapnyName) &&
                Objects.equals(netSalesPercentageChange, f1.netSalesPercentageChange) &&
                Objects.equals(ebitdaPercentageChange, f1.ebitdaPercentageChange) &&
                Objects.equals(netProfitOrLossPercentageChange, f1.netProfitOrLossPercentageChange) &&
                Objects.equals(liabilitesAndProvisionsPercentageChange, f1.liabilitesAndProvisionsPercentageChange) &&
                Objects.equals(equityPercentageChange, f1.equityPercentageChange) &&
                Objects.equals(totalAssetsPercentageChange, f1.totalAssetsPercentageChange);
    }

}

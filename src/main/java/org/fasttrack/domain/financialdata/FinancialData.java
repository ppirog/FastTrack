package org.fasttrack.domain.financialdata;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
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
import java.util.List;
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

    @ElementCollection
    private List<Double> netSalesValues;
    @ElementCollection
    private List<Double> ebitdaValues;
    @ElementCollection
    private List<Double> netProfitOrLossValues;
    @ElementCollection
    private List<Double> liabilitesAndProvisionsValues;
    @ElementCollection
    private List<Double> equityValues;
    @ElementCollection
    private List<Double> totalAssetsValues;


    public boolean areEqualDataExceptFetchDateAndId(FinancialData f1) {
        if (this == f1) return true;
        if (f1 == null) return false;
        if (!this.krsNumber.equals(f1.krsNumber)) return false;
        if (!this.comapnyName.equals(f1.comapnyName)) return false;

        if(this.netSalesValues.size() != f1.netSalesValues.size()) return false;
        if(this.ebitdaValues.size() != f1.ebitdaValues.size()) return false;
        if(this.netProfitOrLossValues.size() != f1.netProfitOrLossValues.size()) return false;
        if(this.liabilitesAndProvisionsValues.size() != f1.liabilitesAndProvisionsValues.size()) return false;
        if(this.equityValues.size() != f1.equityValues.size()) return false;
        if(this.totalAssetsValues.size() != f1.totalAssetsValues.size()) return false;

        for (int i = 0; i < this.netSalesValues.size(); i++) {
            if (!Objects.equals(this.netSalesValues.get(i), f1.netSalesValues.get(i))) return false;
            if (!Objects.equals(this.ebitdaValues.get(i), f1.ebitdaValues.get(i))) return false;
            if (!Objects.equals(this.netProfitOrLossValues.get(i), f1.netProfitOrLossValues.get(i))) return false;
            if (!Objects.equals(this.liabilitesAndProvisionsValues.get(i), f1.liabilitesAndProvisionsValues.get(i))) return false;
            if (!Objects.equals(this.equityValues.get(i), f1.equityValues.get(i))) return false;
            if (!Objects.equals(this.totalAssetsValues.get(i), f1.totalAssetsValues.get(i))) return false;
        }

        return true;
    }

}

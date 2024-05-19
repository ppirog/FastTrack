package org.fasttrack.domain.creditreport;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Builder
@Entity
@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Table(name = "credit_report"
        , indexes = {
        @Index(name = "idx_company_name_credit_report", columnList = "comapnyName"),
        @Index(name = "idx_krs_number_credit_report", columnList = "krsNumber")
})
@ToString(exclude = {"id"})
class CreditReport {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String krsNumber;

    @Column(nullable = false)
    private String comapnyName;

    @Column(nullable = false)
    private Long percentageScore;

    @ElementCollection
    private List<String> descriptions;


}

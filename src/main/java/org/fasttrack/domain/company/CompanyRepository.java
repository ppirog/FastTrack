package org.fasttrack.domain.company;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface CompanyRepository extends JpaRepository<Company, Long> {
    Company save(Company company);
    Optional<Company> findById(Long id);
    Optional<Company> findByName(String name);
    Optional<Company> findByKRSnumber(String KRSnumber);
    List<Company> findAll();

    @Query("select (count(c) > 0) from Company c where c.KRSnumber = ?1")
    boolean existsByKRSnumber(String KRSnumber); //    void deleteByID(Long id);
}

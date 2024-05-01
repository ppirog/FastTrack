package org.fasttrack.domain.company;

import org.springframework.data.jpa.repository.JpaRepository;

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
//    void deleteByID(Long id);
}

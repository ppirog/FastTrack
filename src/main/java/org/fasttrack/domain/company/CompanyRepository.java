package org.fasttrack.domain.company;

import java.util.List;
import java.util.Optional;

interface CompanyRepository {
    Company save(Company company);
    Optional<Company> findById(Long id);
    Optional<Company> findByName(String name);
    Optional<Company> findByKRSnumber(String KRSnumber);
    List<Company> findAll();
    void delete(Long id);
}

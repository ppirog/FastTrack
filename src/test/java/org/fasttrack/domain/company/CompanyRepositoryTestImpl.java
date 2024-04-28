package org.fasttrack.domain.company;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
class CompanyRepositoryTestImpl implements CompanyRepository {

    private final HashMap<Long, Company> database = new HashMap<>();

    public CompanyRepositoryTestImpl(List<Company> companies) {
        companies.forEach(this::save);
    }


    @Override
    public Company save(final Company company) {

        Long id = (long) database.size() + 1;
        company.setId(id);
        database.put(id, company);
        return company;
    }

    @Override
    public Optional<Company> findById(final Long id) {
        return Optional.ofNullable(database.get(id));
    }

    @Override
    public Optional<Company> findByName(final String name) {
        return database.values().stream()
                .filter(company -> company.getName().equals(name))
                .findFirst();
    }

    @Override
    public Optional<Company> findByKRSnumber(final String KRSnumber) {
        return database.values().stream()
                .filter(company -> company.getKRSnumber().equals(KRSnumber))
                .findFirst();
    }

    @Override
    public List<Company> findAll() {
        return database.values().stream().toList();
    }


    @Override
    public void delete(final Long id) {
        database.remove(id);
    }
}

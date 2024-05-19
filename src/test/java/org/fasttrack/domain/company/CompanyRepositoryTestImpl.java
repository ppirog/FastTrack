package org.fasttrack.domain.company;

import lombok.NoArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

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
    public boolean existsById(final Long aLong) {
        return false;
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
    public <S extends Company> List<S> saveAll(final Iterable<S> entities) {
        return List.of();
    }

    @Override
    public List<Company> findAll() {
        return database.values().stream().toList();
    }

    @Override
    public boolean existsByKRSnumber(final String KRSnumber) {
        return false;
    }

    @Override
    public List<Company> findAllById(final Iterable<Long> longs) {
        return List.of();
    }


    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(final Long aLong) {

    }

    @Override
    public void delete(final Company entity) {

    }

    @Override
    public void deleteAllById(final Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(final Iterable<? extends Company> entities) {

    }

    @Override
    public void deleteAll() {

    }


    @Override
    public void flush() {

    }

    @Override
    public <S extends Company> S saveAndFlush(final S entity) {
        return null;
    }

    @Override
    public <S extends Company> List<S> saveAllAndFlush(final Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(final Iterable<Company> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(final Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Company getOne(final Long aLong) {
        return null;
    }

    @Override
    public Company getById(final Long aLong) {
        return null;
    }

    @Override
    public Company getReferenceById(final Long aLong) {
        return null;
    }

    @Override
    public <S extends Company> Optional<S> findOne(final Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Company> List<S> findAll(final Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Company> List<S> findAll(final Example<S> example, final Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Company> Page<S> findAll(final Example<S> example, final Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Company> long count(final Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Company> boolean exists(final Example<S> example) {
        return false;
    }

    @Override
    public <S extends Company, R> R findBy(final Example<S> example, final Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public List<Company> findAll(final Sort sort) {
        return List.of();
    }

    @Override
    public Page<Company> findAll(final Pageable pageable) {
        return null;
    }
}

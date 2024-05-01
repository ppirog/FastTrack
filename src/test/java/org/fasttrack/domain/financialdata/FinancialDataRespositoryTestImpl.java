package org.fasttrack.domain.financialdata;


import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

class FinancialDataRespositoryTestImpl implements FinancialDataRepository{
    private final HashMap<Long, FinancialData> database = new HashMap<>();


    @Override
    public FinancialData save(final FinancialData financialData) {
        Long id = (long) database.size() + 1;
        financialData.setId(id);
        database.put(id, financialData);
        return financialData;
    }

    @Override
    public Optional<FinancialData> findById(final Long id) {
        return Optional.ofNullable(database.get(id));
    }

    @Override
    public Optional<FinancialData> findByComapnyName(final String name) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(final Long aLong) {
        return false;
    }

//    @Override
//    public Optional<FinancialData> findByCompanyName(final String name) {
//        return database.values().stream()
//                .filter(company -> company.getComapnyName().equals(name))
//                .findFirst();
//    }

    @Override
    public List<FinancialData> findByKrsNumberOrderByFetchDateDesc(final String KRSnumber) {
        return database.values().stream()
                .filter(company -> company.getKrsNumber().equals(KRSnumber))
                .toList();
    }

    @Override
    public <S extends FinancialData> List<S> saveAll(final Iterable<S> entities) {
        return List.of();
    }

    @Override
    public List<FinancialData> findAll() {
        return database.values().stream().toList();
    }

    @Override
    public List<FinancialData> findAllById(final Iterable<Long> longs) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }


    @Override
    public void deleteById(final Long id) {
        database.remove(id);
    }

    @Override
    public void delete(final FinancialData entity) {

    }

    @Override
    public void deleteAllById(final Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(final Iterable<? extends FinancialData> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends FinancialData> S saveAndFlush(final S entity) {
        return null;
    }

    @Override
    public <S extends FinancialData> List<S> saveAllAndFlush(final Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(final Iterable<FinancialData> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(final Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public FinancialData getOne(final Long aLong) {
        return null;
    }

    @Override
    public FinancialData getById(final Long aLong) {
        return null;
    }

    @Override
    public FinancialData getReferenceById(final Long aLong) {
        return null;
    }

    @Override
    public <S extends FinancialData> Optional<S> findOne(final Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends FinancialData> List<S> findAll(final Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends FinancialData> List<S> findAll(final Example<S> example, final Sort sort) {
        return List.of();
    }

    @Override
    public <S extends FinancialData> Page<S> findAll(final Example<S> example, final Pageable pageable) {
        return null;
    }

    @Override
    public <S extends FinancialData> long count(final Example<S> example) {
        return 0;
    }

    @Override
    public <S extends FinancialData> boolean exists(final Example<S> example) {
        return false;
    }

    @Override
    public <S extends FinancialData, R> R findBy(final Example<S> example, final Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public List<FinancialData> findAll(final Sort sort) {
        return List.of();
    }

    @Override
    public Page<FinancialData> findAll(final Pageable pageable) {
        return null;
    }
}

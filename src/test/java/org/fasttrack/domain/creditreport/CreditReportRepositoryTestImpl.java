package org.fasttrack.domain.creditreport;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

class CreditReportRepositoryTestImpl implements CreditReportRepository {
    private final HashMap<Long, CreditReport> database = new HashMap<>();

    @Override
    public void flush() {

    }

    @Override
    public <S extends CreditReport> S saveAndFlush(final S entity) {
        return null;
    }

    @Override
    public <S extends CreditReport> List<S> saveAllAndFlush(final Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(final Iterable<CreditReport> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(final Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public CreditReport getOne(final Long aLong) {
        return null;
    }

    @Override
    public CreditReport getById(final Long aLong) {
        return null;
    }

    @Override
    public CreditReport getReferenceById(final Long aLong) {
        return null;
    }

    @Override
    public <S extends CreditReport> Optional<S> findOne(final Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends CreditReport> List<S> findAll(final Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends CreditReport> List<S> findAll(final Example<S> example, final Sort sort) {
        return List.of();
    }

    @Override
    public <S extends CreditReport> Page<S> findAll(final Example<S> example, final Pageable pageable) {
        return null;
    }

    @Override
    public <S extends CreditReport> long count(final Example<S> example) {
        return 0;
    }

    @Override
    public <S extends CreditReport> boolean exists(final Example<S> example) {
        return false;
    }

    @Override
    public <S extends CreditReport, R> R findBy(final Example<S> example, final Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends CreditReport> S save(final S entity) {
        Long id = (long) database.size() + 1;
        entity.setId(id);
        database.put(id, entity);
        return entity;
    }

    @Override
    public <S extends CreditReport> List<S> saveAll(final Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<CreditReport> findById(final Long aLong) {
        return Optional.ofNullable(database.get(aLong));
    }

    @Override
    public boolean existsById(final Long aLong) {
        return false;
    }

    @Override
    public List<CreditReport> findAll() {
        return List.of();
    }

    @Override
    public List<CreditReport> findAllById(final Iterable<Long> longs) {
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
    public void delete(final CreditReport entity) {

    }

    @Override
    public void deleteAllById(final Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(final Iterable<? extends CreditReport> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<CreditReport> findAll(final Sort sort) {
        return List.of();
    }

    @Override
    public Page<CreditReport> findAll(final Pageable pageable) {
        return null;
    }

    @Override
    public List<CreditReport> findByKrsNumber(final String krsNumber) {
        return database.values().stream()
                .filter(company -> company.getKrsNumber().equals(krsNumber))
                .toList();
    }

    @Override
    public long deleteByKrsNumber(final String krsNumber) {
    //fetch key based on value
        Long key = database.entrySet().stream()
                .filter(entry -> entry.getValue().getKrsNumber().equals(krsNumber))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        database.remove(key);
        //        return database.values().removeIf(company -> company.getKrsNumber().equals(krsNumber)) ? 1 : 0;
        return (long) key;
    }
}

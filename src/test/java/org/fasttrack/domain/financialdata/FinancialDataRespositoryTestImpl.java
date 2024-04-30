package org.fasttrack.domain.financialdata;


import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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
    public Optional<FinancialData> findByName(final String name) {
        return database.values().stream()
                .filter(company -> company.getComapnyName().equals(name))
                .findFirst();
    }

    @Override
    public Optional<FinancialData> findByKRSnumber(final String KRSnumber) {
        return database.values().stream()
                .filter(company -> company.getKrsNumber().equals(KRSnumber))
                .findFirst();
    }

    @Override
    public List<FinancialData> findAll() {
        return database.values().stream().toList();
    }


    @Override
    public void delete(final Long id) {
        database.remove(id);
    }
}

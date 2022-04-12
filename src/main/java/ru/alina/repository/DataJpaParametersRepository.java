package ru.alina.repository;

import org.springframework.stereotype.Repository;
import ru.alina.model.Parameters;

import java.util.List;

@Repository
public class DataJpaParametersRepository implements ParametersRepository {


    private final DataJpaParameters dataJpaParameters;

    public DataJpaParametersRepository(DataJpaParameters dataJpaParameters) {
        this.dataJpaParameters = dataJpaParameters;
    }

    @Override
    public Parameters save(Parameters parameters, Long userId) {

        return dataJpaParameters.save(parameters);
    }

    @Override
    public void delete(Long id) {
        dataJpaParameters.deleteById(id);
    }

    @Override
    public Parameters get(Long id) {
        return dataJpaParameters.findById(id).orElse(null);
    }

    @Override
    public List<Parameters> getAll() {
        return dataJpaParameters.findAll();
    }
}

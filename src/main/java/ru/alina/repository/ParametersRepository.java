package ru.alina.repository;

import ru.alina.model.Parameters;

import java.util.List;

public interface ParametersRepository {
    Parameters save(Parameters parameters, Long userId);

    void delete(Long id);

    // null if not found
    Parameters get(Long id);

    List<Parameters> getAll();
}

package ru.alina.repository;

import ru.alina.model.Notation;

import java.util.List;

public interface NotationRepository {
    Notation save(Notation notation, Long userId);

    void delete(Long id, Long userId);

    // null if meal do not belong to userId
    Notation get(Long id, Long userId);

    List<Notation> getAll(Long userId);
}

package ru.alina.repository;

import ru.alina.model.Notation;

import java.util.List;

public interface NotationRepository {
    Notation save(Notation notation, int userId);

    void delete(int id, int userId);

    // null if meal do not belong to userId
    Notation get(int id, int userId);

    List<Notation> getAll(int userId);
}

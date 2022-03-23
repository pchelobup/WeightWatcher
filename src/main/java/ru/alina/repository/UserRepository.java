package ru.alina.repository;

import ru.alina.model.User;

import java.util.List;

public interface UserRepository {
    User save(User user);

    void delete(int id);

    // null if not found
    User get(int id);

    List<User> getAll();
}

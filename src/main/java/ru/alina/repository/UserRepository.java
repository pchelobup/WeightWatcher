package ru.alina.repository;

import ru.alina.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);

    void delete(Long id);

    // null if not found
    User get(Long id);

    List<User> getAll();

    Optional<User> getByEmail(String email);
}

package ru.alina.repository;

import org.springframework.stereotype.Repository;
import ru.alina.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public class DataJpaUserRepository implements UserRepository {
    private final DataJpaUser dataJpaUser;

    public DataJpaUserRepository(DataJpaUser dataJpaUser) {
        this.dataJpaUser = dataJpaUser;
    }

    @Override
    public User save(User user) {
        return dataJpaUser.save(user);
    }

    @Override
    public void delete(int id) {
        dataJpaUser.delete(id);
    }

    @Override
    public User get(int id) {
        return dataJpaUser.findById(id).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return dataJpaUser.findAll();
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return dataJpaUser.findByEmail(email);
    }
}

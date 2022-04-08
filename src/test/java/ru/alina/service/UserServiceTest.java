package ru.alina.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import ru.alina.model.User;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.alina.UserData.*;

class UserServiceTest extends ServiceTest {

    @Autowired
    UserService service;
    @Test
    void create() {
        User created = service.save(getNew());
        long newId = created.getId();
        User user = getNew();
        user.setId(newId);
        match(created, user);
        match(service.get(newId), user);
    }

    @Test
    void duplicateEmail() {
        assertThrows(DataIntegrityViolationException.class,
                () -> service.save(USER_SAME_EMAIL));
    }

    @Test
    void unsuitedPassword() {
        assertThrows(DataIntegrityViolationException.class,
                () -> service.save(USER_UNSUITABLE_PASSWORD));
    }

    @Test
    void update() {
        User updated = getUpdated(service.get(USER1.getId()));
        service.save(updated);
        match(service.get(USER1.getId()), updated);
    }

    @Test
    void delete() {
        service.delete(USER1.getId());
        User user = service.get(USER1.getId());
        match(user, null);
    }

    @Test
    void get() {
        User actual = service.get(1L);
        match(actual, USER1);

    }

    @Test
    void getNotFound() {
        User user = service.get(NOT_FOUND_ID);
        match(user, null);
    }

    @Test
    void getAll() {
        match(service.getAll(),  USERS);
    }

    @Test
    void getByEmail() {
        match(service.getByEmail(USER1.getEmail()).orElseThrow(), USER1);
    }

    @Test
    void getIdByEmail() {
        assertThat(service.getIdByEmail(USER1.getEmail())).isEqualTo(USER1.getId());
    }

}
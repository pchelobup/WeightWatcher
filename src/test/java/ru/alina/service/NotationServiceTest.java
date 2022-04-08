package ru.alina.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.alina.model.Notation;
import static ru.alina.NotationData.*;

class NotationServiceTest extends ServiceTest {

    @Autowired
    NotationService service;


    @Test
    void create() {
        Notation created = service.save(getNew(), USER1_ID);
        Long newId = created.getId();
        Notation notation = getNew();
        notation.setId(newId);
        match(created, notation);
        match(service.get(newId, USER1_ID), notation);
    }


    @Test
    void update() {
        Notation updated = getUpdated();
        service.save(updated, USER1_ID);
        match(service.get(NOTATION1.getId(), USER1_ID), updated);
    }

    @Test
    void updateNotOwn() {
        Notation updated = getUpdated();
        Notation notation = service.save(updated, USER2_ID);
        match(notation, null);

        Notation actual = service.get(NOTATION1.getId(), USER1_ID);
        match(actual, NOTATION1);
    }

    @Test
    void delete() {
        service.delete(NOTATION1.getId(), USER1_ID);
        Notation user = service.get(NOTATION1.getId(), USER1_ID);
        match(user, null);
    }

    @Test
    void deleteNotOwn() {
        service.delete(NOTATION1.getId(), USER2_ID);
        Notation user = service.get(NOTATION1.getId(), USER1_ID);
        match(user, NOTATION1);
    }

    @Test
    void get() {
        Notation actual = service.get(NOTATION1.getId(), USER1_ID);
        match(actual, NOTATION1);

    }

    @Test
    void getNotOwn() {
        Notation notation = service.get(NOTATION1.getId(), USER2_ID);
        match(notation, null);
    }

    @Test
    void getNotFound() {
        Notation notation = service.get(NOT_FOUND_ID, USER1_ID);
        match(notation, null);
    }

    @Test
    void getAll() {
        match(service.getAll(USER1_ID), NOTATIONS);
    }
}
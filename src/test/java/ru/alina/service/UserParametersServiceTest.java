package ru.alina.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.alina.UserData;
import ru.alina.model.Parameters;
import ru.alina.model.User;

import java.util.List;
import static ru.alina.UserParametersData.*;


class UserParametersServiceTest extends ServiceTest {

    @Autowired
    ParametersService service;

    @Autowired
    UserService userService;


    @Test
    void create() {
        User user = userService.save(UserData.getNew());
        Parameters created = service.save(getNew(), user.getId());
        Long newId = created.getUser().getId();
        Parameters userParameters = getNew();
        userParameters.setId(newId);
        match(created, userParameters);
        match(service.get(newId), userParameters);
    }



    @Test
    void update() {
        Parameters updated = getUpdated();
        updated.setUser(UserData.USER1);
        service.save(updated, UserData.USER1.getId());
        match(service.get(USER_PARAMETERS_1.getId()), updated);
    }

    @Test
    void delete() {
        service.delete(USER_PARAMETERS_1.getId());
        match(service.get(USER_PARAMETERS_1.getId()), null);
    }

    @Test
    void get() {
        Parameters actual = service.get(USER_PARAMETERS_1.getId());
        match(actual, USER_PARAMETERS_1);
    }

    @Test
    void getAll() {
        List<Parameters> actual = service.getAll();
        match(actual, USER_PARAMETERS);
    }
}
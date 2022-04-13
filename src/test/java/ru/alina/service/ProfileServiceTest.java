package ru.alina.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.alina.UserData;
import ru.alina.model.Profile;
import ru.alina.model.User;
import java.util.List;
import static ru.alina.ProfileData.*;


class ProfileServiceTest extends ServiceTest {

    @Autowired
    ProfileService service;

    @Autowired
    UserService userService;


    @Test
    void create() {
        User user = userService.save(UserData.getNew());
        Profile created = service.save(getNew(), user.getId());
        Long newId = created.getUser().getId();
        Profile profile = getNew();
        profile.setId(newId);
        match(created, profile);
        match(service.get(newId), profile);
    }



    @Test
    void update() {
        Profile updated = getUpdated();
        updated.setUser(UserData.USER1);
        service.save(updated, UserData.USER1.getId());
        match(service.get(PROFILE_1.getId()), updated);
    }

    @Test
    void updateNotOwn() {
        Profile updated = getUpdated();
        updated.setUser(UserData.USER1);
        Assertions.assertThrows(RuntimeException.class, () -> service.save(updated, UserData.USER2.getId()));

    }

    @Test
    void delete() {
        service.delete(PROFILE_1.getId());
        match(service.get(PROFILE_1.getId()), null);
    }

    @Test
    void get() {
        Profile actual = service.get(PROFILE_1.getId());
        match(actual, PROFILE_1);
    }

    @Test
    void getAll() {
        List<Profile> actual = service.getAll();
        match(actual, PROFILES);
    }


}
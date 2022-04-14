package ru.alina;

import ru.alina.model.*;

import java.util.List;


public class UserData {
    public static final User USER1 = new User(1L, "mail@Mail.com", "$2a$12$FzYWgZ.ukSJS9KAtZZvHkOVw5iOGKibZlenQ1AxytGbnBAmGPaP9y", Status.ACTIVE, Role.USER, Role.ADMIN);
    public static final User USER2 = new User(2L, "pochta@Mail.com", "$2a$12$Hj2g8faouoYrKl7zOaNzf.Uo3rUhQG3vNohgq7EgxqMzLGJ6wdiY.", Status.ACTIVE, Role.USER);
    public static final User USER_SAME_EMAIL = new User("mail@Mail.com", "123445", Status.ACTIVE, Role.USER);
    public static final User USER_UNSUITABLE_PASSWORD = new User("mail@Mail.com", "123", Status.ACTIVE, Role.USER);
    public static final Long NOT_FOUND_ID = 555L;
    public static final List<User> USERS = List.of(USER1, USER2);

    public static User getNew() {
        return new User("new@Mail.com", "12345", Status.ACTIVE, Role.USER);
    }


    public static User getUpdated(User user) {
        user.setStatus(Status.DELETED);
        return user;
    }

    public static void match(User actual, User expected) {
        Matcher.match(actual, expected, "registered");
    }
    
    public static void matchNoPass(User actual, User expected) {
        Matcher.match(actual, expected, "registered", "password");
    }

    public static void match(List<User> actual, List<User> expected) {
        Matcher.match(actual, expected, "registered");
    }

}

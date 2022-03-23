package ru.alina;

import ru.alina.model.Activity;
import ru.alina.model.Gender;
import ru.alina.model.User;

import java.util.List;


public class UserData {
    public static final User USER1 = new User(1, "mail@Mail.com", "12345", Gender.MALE, 180, 55, Activity.MIN, 100, 90, 2000);
    public static final User USER2 = new User(2, "pochta@Mail.com", "zxcvb", Gender.FEMALE, 150, 16, Activity.MIN, 55, 40, 1000);
    public static final User USER_SAME_EMAIL = new User("mail@Mail.com", "123445", Gender.MALE, 140, 65, Activity.MAX, 100, 90, 2000);
    public static final User USER_UNSUITABLE_PASSWORD = new User("mail@Mail.com", "123", Gender.MALE, 140, 65, Activity.MAX, 100, 90, 2000);
    public static final Integer NOT_FOUND_ID = 555;
    public static final List<User> USERS = List.of(USER1, USER2);

    public static User getNew() {
        return new User("new@Mail.com", "12345", Gender.MALE, 190, 155, Activity.MIDDLE, 100, 90, 2500);
    }

    public static User getUpdated() {
        return new User(USER1.getId(), USER1.getEmail(), USER1.getPassword(), USER1.getGender(), USER1.getHeight(), USER1.getAge(), Activity.MIDDLE, USER1.getStartWeight(), 80, 1800);
    }

    public static void match(User actual, User expected) {
        Matcher.match(actual, expected, "registered");
    }

    public static void match(List<User> actual, List<User> expected) {
        Matcher.match(actual, expected, "registered");
    }

}

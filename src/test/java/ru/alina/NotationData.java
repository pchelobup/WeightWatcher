package ru.alina;

import ru.alina.model.Notation;

import java.time.LocalDate;
import java.util.List;

public class NotationData {
    public static final Notation NOTATION1 = new Notation(3L, UserData.USER1, LocalDate.of(2020, 1, 30), 100.1);
    public static final Notation NOTATION2 = new Notation(4L, UserData.USER1, LocalDate.of(2020, 1, 31), 99.4);
    public static final Notation NOTATION3 = new Notation(5L, UserData.USER2, LocalDate.of(2022, 1, 31), 54.9);
    public static final Notation NOTATION4 = new Notation(6L, UserData.USER2, LocalDate.of(2022, 2, 1), 54.6);
    public static final Notation NOTATION5 = new Notation(7L, UserData.USER2, LocalDate.of(2022, 2, 2), 54.7);

    public static final Long NOT_FOUND_ID = 555L;

    public static final Long USER1_ID = UserData.USER1.getId();
    public static final Long USER2_ID = UserData.USER2.getId();

    public static final List<Notation> NOTATIONS = List.of(NOTATION1, NOTATION2);

    public static Notation getNew() {
        return new Notation(UserData.USER1, LocalDate.of(2022, 3, 23), 50.55);
    }

    public static Notation getUpdated() {
        return new Notation(NOTATION1.getId(), NOTATION1.getUser(), NOTATION1.getAdded(), 10000.1);
    }

    public static void match(Notation actual, Notation expected) {
        Matcher.match(actual, expected, "user");
    }

    public static void match(List<Notation> actual, List<Notation> expected) {
        Matcher.match(actual, expected, "user");
    }
}

package ru.alina;

import ru.alina.model.Notation;

import java.time.LocalDate;
import java.util.List;

public class NotationData {
    public static final Notation NOTATION1 = new Notation(3, UserData.USER1, LocalDate.of(2020, 01, 30), 100.1);
    public static final Notation NOTATION2 = new Notation(4, UserData.USER1, LocalDate.of(2020, 01, 31), 99.4);
    public static final Notation NOTATION3 = new Notation(5, UserData.USER2, LocalDate.of(2022, 01, 31), 54.9);
    public static final Notation NOTATION4 = new Notation(6, UserData.USER2, LocalDate.of(2022, 02, 01), 54.6);
    public static final Notation NOTATION5 = new Notation(7, UserData.USER2, LocalDate.of(2022, 02, 02), 54.7);

    public static final Integer NOT_FOUND_ID = 555;

    public static final Integer USER1_ID = UserData.USER1.getId();
    public static final Integer USER2_ID = UserData.USER2.getId();

    public static final List<Notation> NOTATIONS = List.of(NOTATION1, NOTATION2);

    public static Notation getNew() {
        return new Notation(UserData.USER1, LocalDate.of(2022, 03, 23), 50.55);
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

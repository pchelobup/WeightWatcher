package ru.alina;

import ru.alina.model.Activity;
import ru.alina.model.Gender;
import ru.alina.model.Parameters;

import java.util.List;

public class UserParametersData {
    public final static Parameters USER_PARAMETERS_1 = new Parameters(1L, Gender.MALE, 180, 55, Activity.MIN, 100D, 90D, 2000);
    public final static Parameters USER_PARAMETERS_2 = new Parameters(2L, Gender.FEMALE, 150, 16, Activity.MIN, 55D, 40D, 1000);

    public final static List<Parameters> USER_PARAMETERS = List.of(USER_PARAMETERS_1, USER_PARAMETERS_2);

    public static Parameters getNew() {
        return new Parameters(USER_PARAMETERS_1.getGender(), USER_PARAMETERS_1.getHeight(), USER_PARAMETERS_1.getAge(), Activity.MAX, USER_PARAMETERS_1.getStartWeight(), USER_PARAMETERS_1.getDesiredWeight(), 2500);
    }

    public static Parameters getUpdated() {
        return new Parameters(USER_PARAMETERS_1.getId(), USER_PARAMETERS_1.getGender(), USER_PARAMETERS_1.getHeight(), USER_PARAMETERS_1.getAge(), Activity.MIDDLE, USER_PARAMETERS_1.getStartWeight(), 10.0, 1000);
    }

    public static void match(Parameters actual, Parameters expected) {
        Matcher.match(actual, expected, "user");
    }

    public static void match(List<Parameters> actual, List<Parameters> expected) {
        Matcher.match(actual, expected, "user");
    }
}

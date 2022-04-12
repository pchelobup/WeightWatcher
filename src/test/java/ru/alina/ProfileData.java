package ru.alina;

import ru.alina.model.Activity;
import ru.alina.model.Gender;
import ru.alina.model.Profile;

import java.util.List;

public class ProfileData {
    public final static Profile PROFILE_1 = new Profile(1L, Gender.MALE, 180, 55, Activity.MIN, 100D, 90D, 2000);
    public final static Profile PROFILE_2 = new Profile(2L, Gender.FEMALE, 150, 16, Activity.MIN, 55D, 40D, 1000);

    public final static List<Profile> PROFILES = List.of(PROFILE_1, PROFILE_2);

    public static Profile getNew() {
        return new Profile(PROFILE_1.getGender(), PROFILE_1.getHeight(), PROFILE_1.getAge(), Activity.MAX, PROFILE_1.getStartWeight(), PROFILE_1.getDesiredWeight(), 2500);
    }

    public static Profile getUpdated() {
        return new Profile(PROFILE_1.getId(), PROFILE_1.getGender(), PROFILE_1.getHeight(), PROFILE_1.getAge(), Activity.MIDDLE, PROFILE_1.getStartWeight(), 10.0, 1000);
    }

    public static void match(Profile actual, Profile expected) {
        Matcher.match(actual, expected, "user");
    }

    public static void match(List<Profile> actual, List<Profile> expected) {
        Matcher.match(actual, expected, "user");
    }
}

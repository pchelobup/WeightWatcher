package ru.alina;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Matcher {
    public static<T> void match(T actual, T expected, String...ignore) {
        assertThat(actual)
                .usingRecursiveComparison()
                .ignoringFields(ignore)
                .isEqualTo(expected);
    }

    public static<T> void match(List<T> actual, List<T> expected, String...ignore) {
        assertThat(actual)
                .usingRecursiveComparison()
                .ignoringFields(ignore)
                .isEqualTo(expected);
    }
}

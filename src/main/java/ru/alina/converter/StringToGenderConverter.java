package ru.alina.converter;

import org.springframework.core.convert.converter.Converter;
import ru.alina.model.Gender;

public class StringToGenderConverter implements Converter<String, Gender> {
    @Override
    public Gender convert(String source) {
        return Gender.valueOf(source.toUpperCase());
    }
}

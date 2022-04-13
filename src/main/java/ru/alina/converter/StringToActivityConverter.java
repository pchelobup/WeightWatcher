package ru.alina.converter;

import org.springframework.core.convert.converter.Converter;
import ru.alina.model.Activity;


public class StringToActivityConverter implements Converter<String, Activity> {
    @Override
    public Activity convert(String source) {
        return Activity.valueOf(source.toUpperCase());
    }
}

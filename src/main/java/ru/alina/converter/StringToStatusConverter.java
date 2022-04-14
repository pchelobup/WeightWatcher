package ru.alina.converter;

import org.springframework.core.convert.converter.Converter;
import ru.alina.model.Status;

public class StringToStatusConverter implements Converter<String, Status> {
    @Override
    public Status convert(String source) {
        return Status.valueOf(source.toUpperCase());
    }
}

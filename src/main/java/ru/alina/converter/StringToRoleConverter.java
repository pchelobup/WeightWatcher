package ru.alina.converter;

import org.springframework.core.convert.converter.Converter;
import ru.alina.model.Role;

public class StringToRoleConverter implements Converter<String, Role> {
    @Override
    public Role convert(String source) {
        return Role.valueOf(source.toUpperCase());
    }
}

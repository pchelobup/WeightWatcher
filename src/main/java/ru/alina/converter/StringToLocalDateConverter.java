package ru.alina.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;

public class StringToLocalDateConverter implements Converter<String, LocalDate> {

    @Override
    public LocalDate convert(String source) {
        LocalDate date =  LocalDate.parse(source);
        System.out.println(date + " DATE!!!!!!!!!!!!!!!!");
        return date;
    }
}

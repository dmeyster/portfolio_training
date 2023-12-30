package spring.example.java.portfolio_training.converters;

import org.springframework.core.convert.converter.Converter;
import spring.example.java.portfolio_training.beans.Gender;

public class StringToEnumConvertor implements Converter<String, Gender> {
    @Override
    public Gender convert(String s) {
        try {
            return Gender.valueOf(s.toUpperCase());
        } catch (Exception e) {
            return Gender.OTHER;
        }
    }
}
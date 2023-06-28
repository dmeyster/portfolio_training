package spring.example.java.portfolio_training.converters;

import org.springframework.core.convert.converter.Converter;
import spring.example.java.portfolio_training.beans.Gender;

public class StringToEnumConvertor implements Converter<String, Gender> {
    @Override
    public Gender convert(String s) {
        if(s.equals("Male")){
            return Gender.MALE;
        }
        else if(s.equals("Female")){
            return Gender.FEMALE;
        }
        else{
            return Gender.OTHER;
        }
    }
}
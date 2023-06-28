package spring.example.java.portfolio_training.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import spring.example.java.portfolio_training.beans.Login;
import spring.example.java.portfolio_training.beans.User;

import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class DefaultModelAttributeController {
    @ModelAttribute("newuser")
    public User getDefaultUser(){
        return new User();
    }
    @ModelAttribute("genderItems")
    public List<String> getGenderItems(){
        return Arrays.asList("Male", "Female", "Other");
    }
    @ModelAttribute("login")
    public Login getDefaultLogin(){
        return new Login();
    }
}

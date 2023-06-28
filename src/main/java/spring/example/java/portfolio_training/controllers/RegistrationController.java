package spring.example.java.portfolio_training.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import spring.example.java.portfolio_training.beans.User;
import spring.example.java.portfolio_training.repository.UserRepository;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class RegistrationController {
    //@Autowired
    private final UserRepository userRepository = null;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class, "dateOfBirth", new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    @PostMapping("/registeruser")
    public String registerUser(@Valid @ModelAttribute("newuser") User user, BindingResult result, Model model){
        System.out.println("in registration controller");
        System.out.println(user.getDateOfBirth());

        if(result.hasErrors()){
            return "register";
        }

        //userRepository.save(user);
        model.addAttribute("dataSaved", "User registered successfully");
        return "login";
    }

}

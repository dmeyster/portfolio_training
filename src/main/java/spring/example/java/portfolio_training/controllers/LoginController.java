package spring.example.java.portfolio_training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import spring.example.java.portfolio_training.beans.Login;
import spring.example.java.portfolio_training.beans.User;
import spring.example.java.portfolio_training.exceptions.ApplicationException;
import spring.example.java.portfolio_training.repository.UserRepository;

@Controller

public class LoginController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/login")
    /**@postmapping - create object, @getmapping - get object**/
    public String login(@ModelAttribute("login") Login login, Model model) {
        User user = userRepository.searchByName(login.getUsername());
        if (user == null) {
            throw new ApplicationException("User not found");
        }
        else {
            model.addAttribute("userLoggedIn", user);
        }
        if (login.getPassword().equals(user.getPassword())) { /**проверка пароля**/
            return "index";
        }
        return null;
    }
}
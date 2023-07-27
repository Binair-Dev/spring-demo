package be.bnair.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import be.bnair.springdemo.service.UserService;

@Controller
public class UserController {
    // GET - http://localhost:8080/users

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String displayMessage(Model model){
        model.addAttribute("list", userService.getAll());
        return "users";
    }
}

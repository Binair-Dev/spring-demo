package be.bnair.springdemo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import be.bnair.springdemo.models.dto.UserDTO;
import be.bnair.springdemo.models.form.UserForm;
import be.bnair.springdemo.service.UserService;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("user/users")
    public String getAllUsers(Model model){
        model.addAttribute("list", userService.getAll());
        return "user/users";
    }

    @GetMapping("user/user/{id:[0-9]+}")
    public String displayOne(Model model, @PathVariable long id){
        UserDTO choosenOne = userService.getOne(id);
        model.addAttribute("user", choosenOne);
        return "user/user";
    }

    @GetMapping("user/user-create")
    public String createUser(Model model){
        model.addAttribute("form", new UserForm());
        return "user/user-create";
    }

    @PostMapping("user/user-create")
    public String processCreateUser(@Valid UserForm form, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "user/user-create";
        }
        else userService.create(form);
        return "redirect:/user/users";
    }

    @GetMapping("user/user-edit/{id:[0-9]+}")
    public String editUser(Model model, @PathVariable long id){
        UserForm form = new UserForm();

        UserDTO user = userService.getOne(id);
        form.setPrenom(user.getPrenom());
        form.setNom(user.getNom());
        form.setDate_de_naissance(user.getDate_de_naissance());

        model.addAttribute("form",form);
        model.addAttribute("id",id);
        return "user/user-edit";
    }
    
    @PostMapping("user/user-edit/{id:[0-9]+}")
    public String processUpdateUser(@Valid UserForm form, BindingResult bindingResult, @PathVariable long id) {
        if(bindingResult.hasErrors()) {
            return "user/user-create";
        }
        else userService.update(form, id);
        return "redirect:/user/users";
    }
    
}

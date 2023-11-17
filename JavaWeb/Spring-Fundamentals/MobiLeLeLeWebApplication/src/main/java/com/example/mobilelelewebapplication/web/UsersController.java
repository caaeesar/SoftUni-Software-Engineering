package com.example.mobilelelewebapplication.web;

import com.example.mobilelelewebapplication.model.dto.UserLoginDto;
import com.example.mobilelelewebapplication.model.dto.UserRegistrationDto;
import com.example.mobilelelewebapplication.model.entity.enums.RoleType;
import com.example.mobilelelewebapplication.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute
    public void addDataToModel(Model model) {
        model.addAttribute("roles", RoleType.values());
    }

    @GetMapping("/register")
    public String register() {
        return "auth-register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegistrationDto userRegistrationDto, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
        userService.registerUser(userRegistrationDto);
        return "redirect:login";
        }
        return "redirect:register";
    }

    @GetMapping("/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping("/login")
    public String login(UserLoginDto userLoginDto){
        boolean isLogged = userService.loginUser(userLoginDto);
        if (isLogged) {
            return "redirect:/";
        }
        return "redirect:login";
    }

    @GetMapping("/logout")
    public String logout() {
        userService.logoutUser();
        return "redirect:/";
    }

}

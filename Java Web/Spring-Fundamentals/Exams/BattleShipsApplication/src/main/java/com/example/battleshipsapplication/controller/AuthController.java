package com.example.battleshipsapplication.controller;

import com.example.battleshipsapplication.model.binding.UserLoginBindingModel;
import com.example.battleshipsapplication.model.binding.UserRegisterBindingModel;
import com.example.battleshipsapplication.service.UserService;
import com.example.battleshipsapplication.session.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class AuthController {

    private final LoggedUser loggedUser;
    private final UserService userService;


    @Autowired
    public AuthController(LoggedUser loggedUser, UserService userService) {
        this.loggedUser = loggedUser;
        this.userService = userService;
    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel() {
        return new UserLoginBindingModel();
    }

    @GetMapping("/register")
    public String register() {
        if (loggedUser.isLogged()) {
            return "home";
        }
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterBindingModel userRegisterBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            return "redirect:register";
        }

        boolean isRegistered = userService.registerUser(userRegisterBindingModel);
        if (!isRegistered) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            return "redirect:register";
        }
        return "redirect:login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        if (loggedUser.isLogged()) {
            return "home";
        }
        if (!model.containsAttribute("isValidUserCredentials")) {
            model.addAttribute("isValidUserCredentials", true);
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid UserLoginBindingModel userLoginBindingModel,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);
            return "redirect:login";
        }

        boolean isValidUserCredentials = userService.checkUserCredentials(userLoginBindingModel);
        if (!isValidUserCredentials) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("isValidUserCredentials", false);
            return "redirect:login";
        }

        userService.loginUser(userLoginBindingModel);
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout() {
        userService.logoutUser();
        return "redirect:/";
    }

}

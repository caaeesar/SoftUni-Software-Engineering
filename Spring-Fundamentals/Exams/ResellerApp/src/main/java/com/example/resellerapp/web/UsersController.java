package com.example.resellerapp.web;

import com.example.resellerapp.model.binding.UserLoginBindingModel;
import com.example.resellerapp.model.binding.UserRegisterBindingModel;
import com.example.resellerapp.service.UserService;
import com.example.resellerapp.session.LoggedUser;
import jakarta.servlet.http.HttpSession;
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
public class UsersController {

    private final LoggedUser loggedUser;
    private final UserService userService;

    @Autowired
    public UsersController(LoggedUser loggedUser, UserService userService) {
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
            return "redirect:home";
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
            return "redirect:/users/register";
        }

        userService.registerUser(userRegisterBindingModel);
        return "redirect:/users/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        if (loggedUser.isLogged()) {
            return "redirect:/";
        }
        if (!model.containsAttribute("isExist")) {
            model.addAttribute("isExist", true);
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

        boolean isLogged = userService.loginUser(userLoginBindingModel);
        if (!isLogged) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("isExist", false);
        //return "redirect:/users/login";
            return "redirect:login";
        }
            // TODO: refactor set field to logged user
            loggedUser.setLogged(true);
            loggedUser.setUsername(userLoginBindingModel.getUsername());
            return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/";
    }


}

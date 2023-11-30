package com.example.pathfinder.web;

import com.example.pathfinder.model.binding.UserLoginBindingModel;
import com.example.pathfinder.model.binding.UserRegisterBindingModel;
import com.example.pathfinder.model.view.UserViewModel;
import com.example.pathfinder.model.entity.UserEntity;
import com.example.pathfinder.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UsersController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterBindingModel userRegisterBindingModel,
                           BindingResult bindingResult, // result from validation
                           RedirectAttributes redirectAttributes) { /* save data after redirect */
        if (bindingResult.hasErrors()
          /* (!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword()))*/) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            return "redirect:register";
        }
        userService.registerUser(userRegisterBindingModel);
        return "redirect:login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(UserLoginBindingModel userLoginBindingModel) {
        boolean isLogged = userService.loginUser(userLoginBindingModel);
        if (isLogged) {
            return "redirect:/";
        }
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        userService.logoutUser();
        return "redirect:/";
    }

    @GetMapping("/profile/{id}")
    public String profile(@PathVariable Long id, Model model){
        UserEntity userEntity = userService.findById(id);
        UserViewModel userViewModel = modelMapper.map(userEntity, UserViewModel.class);
        model.addAttribute("user", userViewModel);
        return "profile";
   }

}

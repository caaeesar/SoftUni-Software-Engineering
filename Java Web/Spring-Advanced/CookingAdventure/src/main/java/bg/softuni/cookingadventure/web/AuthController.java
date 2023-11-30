package bg.softuni.cookingadventure.web;

import bg.softuni.cookingadventure.model.binding.UserRegisterBindingModel;
import bg.softuni.cookingadventure.model.entity.UserEntity;
import bg.softuni.cookingadventure.model.entity.enums.RoleName;
import bg.softuni.cookingadventure.model.service.UserServiceModel;
import bg.softuni.cookingadventure.model.view.UserProfileViewModel;
import bg.softuni.cookingadventure.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class AuthController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public AuthController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @ModelAttribute
    public void addRoleNames(Model model) {
        model.addAttribute("roles", RoleName.values());
    }

    @GetMapping("/register")
    public String register() {
        return "auth-register";
    }

    @PostMapping("/register")
    public String registerPost(@Valid UserRegisterBindingModel userRegisterBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            return "redirect:register";
        }

        UserServiceModel userServiceModel = modelMapper.map(userRegisterBindingModel, UserServiceModel.class);
        boolean canRegister = userService.registerUser(userServiceModel);

        if (!canRegister) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            return "redirect:register";
        }
        return "redirect:login";
    }

    @GetMapping("/login")
    public String login() {
        return "auth-login";
    }

    @GetMapping("/profile")
    public String profile(Principal principal, Model model) {
        UserProfileViewModel userProfileViewModel = modelMapper.map(userService.getUserByUsername(principal.getName()), UserProfileViewModel.class);
        model.addAttribute("userProfileViewModel", userProfileViewModel);
        return "profile";
    }

    @PostMapping("/login-error")
    public String loginError(Model model, @RequestParam(name = "username") String username) {
        Optional<UserEntity> userOptional = userService.getUserByUsername(username);

        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();

            if (!user.isActive()) {
                model.addAttribute("inactive", true);
            } else {
                model.addAttribute("badCredentials", true);
            }
        }
        return "auth-login";
    }

}

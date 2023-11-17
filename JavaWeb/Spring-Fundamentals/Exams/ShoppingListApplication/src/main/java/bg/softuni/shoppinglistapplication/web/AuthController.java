package bg.softuni.shoppinglistapplication.web;

import bg.softuni.shoppinglistapplication.model.binding.UserLoginBindingModel;
import bg.softuni.shoppinglistapplication.model.binding.UserRegisterBindingModel;
import bg.softuni.shoppinglistapplication.model.service.UserServiceModel;
import bg.softuni.shoppinglistapplication.service.UserService;
import bg.softuni.shoppinglistapplication.session.LoggedUser;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
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

    private final ModelMapper modelMapper;

    @Autowired
    public AuthController(LoggedUser loggedUser, UserService userService, ModelMapper modelMapper) {
        this.loggedUser = loggedUser;
        this.userService = userService;
        this.modelMapper = modelMapper;
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
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            return "redirect:register";
        }

        UserServiceModel userServiceModel = modelMapper.map(userRegisterBindingModel, UserServiceModel.class);
        boolean isRegistered = userService.registerUser(userServiceModel);

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
    public String loginConfirm(@Valid UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);
            return "redirect:login";
        }

        UserServiceModel userServiceModel = modelMapper.map(userLoginBindingModel, UserServiceModel.class);
        boolean isValidUserCredentials = userService.checkUserCredentials(userServiceModel);

        if (!isValidUserCredentials) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("isValidUserCredentials", false);
            return "redirect:login";
        }

        userService.loginUser(userServiceModel);
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout() {
        if (loggedUser.isLogged()) {
            userService.logout();
            return "redirect:/";
        }
        return "redirect:login";
    }
}

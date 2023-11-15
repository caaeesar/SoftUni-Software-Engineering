package bg.softuni.andreysapplication.web;

import bg.softuni.andreysapplication.model.binding.UserLoginBindingModel;
import bg.softuni.andreysapplication.model.binding.UserRegisterBindingModel;
import bg.softuni.andreysapplication.model.service.UserServiceModel;
import bg.softuni.andreysapplication.service.UserService;
import bg.softuni.andreysapplication.session.SessionUser;
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

    private final UserService userService;
    private final SessionUser sessionUser;
    private final ModelMapper modelMapper;

    @Autowired
    public AuthController(UserService userService, SessionUser sessionUser, ModelMapper modelMapper) {
        this.userService = userService;
        this.sessionUser = sessionUser;
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
        if (sessionUser.isLogged()) {
            return "redirect:/";
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerRequest(@Valid UserRegisterBindingModel userRegisterBindingModel,
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
    public String login(Model model) {
        if (sessionUser.isLogged()){
            return "redirect:/";
        }
        if (!model.containsAttribute("isValidCredentials")) {
            model.addAttribute("isValidCredentials", true);
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginRequest(@Valid UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);
            return "redirect:login";
        }

        UserServiceModel userServiceModel = modelMapper.map(userLoginBindingModel, UserServiceModel.class);
        boolean isValidCredentials = userService.checkCredentials(userServiceModel);

        if (!isValidCredentials) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("isValidCredentials", false);
            return "redirect:login";
        }

        userService.loginUser(userServiceModel);
        return "redirect:/";
    }


    @PostMapping("/logout")
    public String logout() {
        if (sessionUser.isLogged()) {
            userService.logoutUser();
            return "redirect:/";
        }
        return "redirect:login";
    }


}

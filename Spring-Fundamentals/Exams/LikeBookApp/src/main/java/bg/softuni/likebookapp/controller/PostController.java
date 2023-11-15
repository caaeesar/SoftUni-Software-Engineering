package bg.softuni.likebookapp.controller;

import bg.softuni.likebookapp.model.binding.PostAddBindingModel;
import bg.softuni.likebookapp.model.entity.enums.MoodType;
import bg.softuni.likebookapp.model.service.PostServiceModel;
import bg.softuni.likebookapp.service.PostService;
import bg.softuni.likebookapp.session.SessionUser;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final SessionUser sessionUser;
    private final PostService postService;
    private final ModelMapper modelMapper;

    @Autowired
    public PostController(SessionUser sessionUser, PostService postService, ModelMapper modelMapper) {
        this.sessionUser = sessionUser;
        this.postService = postService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public void populateMoods(Model model) {
        model.addAttribute("moods", MoodType.values());
    }

    @ModelAttribute
    public PostAddBindingModel postAddBindingModel() {
        return new PostAddBindingModel();
    }

    @GetMapping("/add")
    public String addPost() {
        if (sessionUser.isLogged()) {
            return "post-add";
        }
        return "redirect:/";
    }

    @PostMapping("/add")
    public String addPostRequest(@Valid PostAddBindingModel postAddBindingModel,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("postAddBindingModel", postAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.postAddBindingModel", bindingResult);
            return "redirect:add";
        }

        PostServiceModel postServiceModel = modelMapper.map(postAddBindingModel, PostServiceModel.class);
        postService.createPost(postServiceModel);
        return "redirect:/";
    }

    @PostMapping("/like/{id}")
    public String likePost(@PathVariable String id){
        postService.likePost(id);
        return "redirect:/";
    }

    @DeleteMapping("/remove/{id}")
    public String removePost(@PathVariable String id) {
        postService.removePost(id);
        return "redirect:/";
    }

}

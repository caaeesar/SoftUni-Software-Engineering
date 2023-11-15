package bg.softuni.likebookapp.controller;

import bg.softuni.likebookapp.model.view.HomePostsViewModel;
import bg.softuni.likebookapp.service.PostService;
import bg.softuni.likebookapp.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final SessionUser sessionUser;
    private final PostService postService;

    @Autowired
    public HomeController(SessionUser sessionUser, PostService postService) {
        this.sessionUser = sessionUser;
        this.postService = postService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        if (sessionUser.isLogged()) {
            HomePostsViewModel homePosts = postService.findAllPostsForHomePage();
            model.addAttribute("homePosts", homePosts);
            return "home";
        }
        return "index";
    }

}

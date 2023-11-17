package bg.softuni.dictionaryapp.controller;

import bg.softuni.dictionaryapp.model.view.HomeWordsViewModel;
import bg.softuni.dictionaryapp.service.WordService;
import bg.softuni.dictionaryapp.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final SessionUser sessionUser;
    private final WordService wordService;

    @Autowired
    public HomeController(SessionUser sessionUser, WordService wordService) {
        this.sessionUser = sessionUser;
        this.wordService = wordService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        if (sessionUser.isLogged()) {
            int allWords = wordService.getAllWords();
            HomeWordsViewModel homeWords = wordService.findAllWordsForHomePage();

            model.addAttribute("homeWords", homeWords)
                    .addAttribute("allWords", allWords);
            return "home";
        }
        return "index";
    }
}

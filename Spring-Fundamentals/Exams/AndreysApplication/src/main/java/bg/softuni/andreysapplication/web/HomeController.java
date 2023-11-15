package bg.softuni.andreysapplication.web;

import bg.softuni.andreysapplication.service.ItemService;
import bg.softuni.andreysapplication.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final SessionUser sessionUser;
    private final ItemService itemService;

    @Autowired
    public HomeController(SessionUser sessionUser, ItemService itemService) {
        this.sessionUser = sessionUser;
        this.itemService = itemService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        if (sessionUser.isLogged()){
            model.addAttribute("itemsForHomePage", itemService.findAllItems());
            return "home";
        }
        return "index";
    }


}

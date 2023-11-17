package com.example.resellerapp.web;

import com.example.resellerapp.model.view.OffersHomeViewModel;
import com.example.resellerapp.service.OfferService;
import com.example.resellerapp.session.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private final LoggedUser loggedUser;
    private final OfferService offerService;

    @Autowired
    public HomeController(LoggedUser loggedUser, OfferService offerService) {
        this.loggedUser = loggedUser;
        this.offerService = offerService;
    }

    @ModelAttribute
    public OffersHomeViewModel offersHomeViewModel() {
        return new OffersHomeViewModel();
    }

    @GetMapping("/")
    public String index(Model model) {
        if (loggedUser.isLogged()) {
            OffersHomeViewModel offersHomeViewModel = offerService.findOffersForHomePage();
            model.addAttribute("homeOffers", offersHomeViewModel);
            return "home";
        }
        return "index";
    }

}

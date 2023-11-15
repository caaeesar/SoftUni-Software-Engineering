package com.example.battleshipsapplication.controller;

import com.example.battleshipsapplication.model.binding.BattleShipsBindingModel;
import com.example.battleshipsapplication.model.view.ShipsHomePage;
import com.example.battleshipsapplication.service.ShipService;
import com.example.battleshipsapplication.session.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private final LoggedUser loggedUser;
    private final ShipService shipService;

    @Autowired
    public HomeController(LoggedUser loggedUser, ShipService shipService) {
        this.loggedUser = loggedUser;
        this.shipService = shipService;
    }

    @ModelAttribute
    public ShipsHomePage shipsHomePage() {
        return new ShipsHomePage();
    }

    @ModelAttribute
    public BattleShipsBindingModel battleShipsBindingModel() {
        return new BattleShipsBindingModel();
    }

    @GetMapping()
    public String home(Model model) {
        if (loggedUser.isLogged()) {

            ShipsHomePage shipsHomePage = shipService.findShipsForHomePage();
            model.addAttribute("shipsHomePage", shipsHomePage);

            return "home";
        }
        return "index";
    }

    @PostMapping("/fire")
    public String fire(BattleShipsBindingModel battleShipsBindingModel) {
        shipService.battle(battleShipsBindingModel);
        return "redirect:/";
    }
}

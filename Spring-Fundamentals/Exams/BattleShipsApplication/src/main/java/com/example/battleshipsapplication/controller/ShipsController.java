package com.example.battleshipsapplication.controller;

import com.example.battleshipsapplication.model.binding.BattleShipsBindingModel;
import com.example.battleshipsapplication.model.binding.ShipAddBindingModel;
import com.example.battleshipsapplication.model.entity.enums.CategoryName;
import com.example.battleshipsapplication.service.ShipService;
import com.example.battleshipsapplication.session.LoggedUser;
import jakarta.validation.Valid;
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
@RequestMapping("/ships")
public class ShipsController {

    private final LoggedUser loggedUser;
    private final ShipService shipService;

    @Autowired
    public ShipsController(LoggedUser loggedUser, ShipService shipService) {
        this.loggedUser = loggedUser;
        this.shipService = shipService;
    }

    @ModelAttribute
    public void addCategoriesToModel(Model model) {
        model.addAttribute("categories", CategoryName.values());
    }

    @ModelAttribute
    public ShipAddBindingModel shipAddBindingModel() {
        return new ShipAddBindingModel();
    }


    @GetMapping("/add")
    public String addShip() {
        if (loggedUser.isLogged()) {
            return "ship-add";
        }
        return "redirect:/";
    }

    @PostMapping("/add")
    public String addShip(@Valid ShipAddBindingModel shipAddBindingModel,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("shipAddBindingModel", shipAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.shipAddBindingModel", bindingResult);
            return "redirect:/ships/add";
        }

        boolean isNameFree = shipService.addShip(shipAddBindingModel);
        if (!isNameFree) {
            redirectAttributes.addFlashAttribute("shipAddBindingModel", shipAddBindingModel);
            return "redirect:/ships/add";
        }
        return "redirect:/";
    }

}

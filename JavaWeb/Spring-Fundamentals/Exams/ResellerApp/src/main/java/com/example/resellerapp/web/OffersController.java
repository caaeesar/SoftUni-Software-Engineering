package com.example.resellerapp.web;

import com.example.resellerapp.model.binding.OfferAddBindingModel;
import com.example.resellerapp.model.entity.Condition;
import com.example.resellerapp.model.entity.enums.ConditionName;
import com.example.resellerapp.service.OfferService;
import com.example.resellerapp.session.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/offers")
public class OffersController {

    private LoggedUser loggedUser;
    private OfferService offerService;

    @Autowired
    public OffersController(LoggedUser loggedUser, OfferService offerService) {
        this.loggedUser = loggedUser;
        this.offerService = offerService;
    }

    @ModelAttribute
    public OfferAddBindingModel offerAddBindingModel(){
        return new OfferAddBindingModel();
    }

    @ModelAttribute
    public void addConditionNamesToModel(Model model){
        model.addAttribute("conditionNames", ConditionName.values());
    }

    @GetMapping("/add")
    public String addOffer() {
        if (loggedUser.isLogged()) {
            return "offer-add";
        }
        return "redirect:/";
    }

    @PostMapping("/add")
    public String addOffer(@Valid OfferAddBindingModel offerAddBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerAddBindingModel", offerAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.offerAddBindingModel", bindingResult);
            return "redirect:/offers/add";
        }

        offerService.addOffer(offerAddBindingModel);
        return "redirect:/";
    }


    @DeleteMapping("/remove/{id}")
    public String removeOffer(@PathVariable String id){
        offerService.removeOffer(id);
        return "redirect:/home";
    }

    @PostMapping("/buy/{id}")
    public String buyItem(@PathVariable String id) {
        offerService.buy(id);
        return "redirect:/";
    }


}

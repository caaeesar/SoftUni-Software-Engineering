package com.example.mobilelelewebapplication.web;

import com.example.mobilelelewebapplication.model.dto.AddOfferDto;
import com.example.mobilelelewebapplication.model.entity.ModelEntity;
import com.example.mobilelelewebapplication.model.entity.enums.Engine;
import com.example.mobilelelewebapplication.model.entity.enums.Transmission;
import com.example.mobilelelewebapplication.service.BrandService;
import com.example.mobilelelewebapplication.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offers")
public class OffersController {

    private final OfferService offerService;
    private final BrandService brandService;

    public OffersController(OfferService offerService, BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }

    @ModelAttribute
    public AddOfferDto addOfferDto() {
        return new AddOfferDto();
    }

    @ModelAttribute
    public void addDataToModel(Model model) {
        model.addAttribute("engines", Engine.values());
        model.addAttribute("transmissions", Transmission.values());
        model.addAttribute("brands", brandService.getAllBrands());
    }

    @GetMapping("/add")
    public String addOffer() {
        return "offer-add";
    }

    @PostMapping("/add")
    public String addOffer(AddOfferDto addOfferDto) {
        offerService.createOffer(addOfferDto);
        return "redirect:/";
    }

    @GetMapping("/all")
    public String allOffers() {
        return "offers";
    }

}

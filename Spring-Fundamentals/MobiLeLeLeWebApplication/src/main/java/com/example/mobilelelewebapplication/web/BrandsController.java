package com.example.mobilelelewebapplication.web;

import com.example.mobilelelewebapplication.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/brands")
public class BrandsController {

    private final BrandService brandService;

    @Autowired
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/all")
    public String allBrands(Model brands) {
        brands.addAttribute("brands", brandService.getAllBrands());
        return "brands";
    }

}

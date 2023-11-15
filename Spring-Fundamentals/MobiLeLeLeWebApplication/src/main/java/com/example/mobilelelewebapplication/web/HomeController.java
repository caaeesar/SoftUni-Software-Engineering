package com.example.mobilelelewebapplication.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// by default visualize index.html for home page
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

}

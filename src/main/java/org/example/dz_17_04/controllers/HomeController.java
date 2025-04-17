package org.example.dz_17_04.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model)
    {
        model.addAttribute("message","Hi");
        return "home/home";
    }
    @GetMapping("/about")
    public String about()
    {
        return "home/about";
    }
}

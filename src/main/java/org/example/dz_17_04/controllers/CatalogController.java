package org.example.dz_17_04.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatalogController {
    @GetMapping("/catalog")
    public String index(Model model)
    {
        return "catalog/index";
    }
}

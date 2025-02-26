package com.rollerspeed.rollerspeed.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index"; // Renderiza la vista index.html
    }

    @GetMapping("/acerca-de")
    public String acercaDe() {
        return "acerca-de"; // Renderiza la vista acerca-de.html
    }

   
}
package com.rollerspeed.rollerspeed.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/acerca-de")
    public String acercaDe() {
        return "acerca-de";
    }

    @GetMapping("/mision")
    public String mision() {
        return "mision";
    }

    @GetMapping("/vision")
    public String vision() {
        return "vision";
    }

    @GetMapping("/valores")
    public String valores() {
        return "valores";
    }

    @GetMapping("/servicios")
    public String servicios() {
        return "servicios";
    }

    @GetMapping("/eventos")
    public String eventos() {
        return "eventos";
    }

   
}
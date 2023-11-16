package com.jjang051.isotope.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/isotope")
public class IsotopeController {
    @GetMapping({"/","/index","/main"})
    public String index() {
        return "/index";
    }
}

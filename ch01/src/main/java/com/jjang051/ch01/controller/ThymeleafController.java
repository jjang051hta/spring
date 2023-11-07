package com.jjang051.ch01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ThymeleafController {
    @GetMapping("/thyme/01")
    public String thyme01(Model model) {
        model.addAttribute("name","장성호");
        model.addAttribute("age",30);
        model.addAttribute("address","서울");
        return "thyme01";
    }

}

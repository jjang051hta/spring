package com.jjang051.outstargram.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping({"/","/index"})
    public String index() {
        return "image/story";
    }
}

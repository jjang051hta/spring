package com.example.aws.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/aaa")
    public String aaa() {
        return "aaa";
    }

    @GetMapping("/bbb")
    public String bbb() {
        return "bbb";
    }
    @GetMapping("/ccc")
    public String ccc() {
        return "ccc";
    }

}

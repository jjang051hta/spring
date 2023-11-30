package com.jjang051.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    @GetMapping("/join")
    public String join() {
        return "/join";
    }

    @PostMapping("/join")
    public String joinProcess() {
        return "/join";
    }

}

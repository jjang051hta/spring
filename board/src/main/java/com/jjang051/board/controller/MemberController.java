package com.jjang051.board.controller;

import com.jjang051.board.dto.LoginDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/member")
@Controller
public class MemberController {

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginDto",new LoginDto());
        return "/member/login";
    }
}

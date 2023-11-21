package com.jjang051.board.controller;

import com.jjang051.board.dto.JoinDto;
import com.jjang051.board.dto.LoginDto;
import com.jjang051.board.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/member")
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginDto",new LoginDto());
        return "/member/login";
    }
    @PostMapping("/login")
    public String loginProcess(@Valid @ModelAttribute LoginDto loginDto,
                               BindingResult bindingResult, Model model) {
        model.addAttribute("loginDto",new LoginDto());
        return "/member/login";
    }
    @GetMapping("/join")
    public String join(Model model) {
        model.addAttribute("joinDto",new JoinDto());
        return "/member/join";
    }
    @PostMapping("/join")
    public String joinProcess(@Valid @ModelAttribute JoinDto joinDto,
                               BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("joinDto",joinDto);
            return "/member/join";
        }
        memberService.insertMember(joinDto);
        return "redirect:/member/login";
    }

}

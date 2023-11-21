package com.jjang051.board.controller;

import com.jjang051.board.dto.JoinDto;
import com.jjang051.board.dto.LoginDto;
import com.jjang051.board.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/member")
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String login( @RequestParam(value = "error", required = false) String error,
                         @RequestParam(value = "exception", required = false) String exception,Model model) {
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);
        model.addAttribute("loginDto",new LoginDto());
        return "/member/login";
    }
 /*   @PostMapping("/login")
    public String loginProcess(@Valid @ModelAttribute LoginDto loginDto,
                               BindingResult bindingResult,
                               Model model) {
        model.addAttribute("loginDto",loginDto);
        return "/member/login";
    }*/
    @GetMapping("/join")
    public String join(Model model) {
        model.addAttribute("joinDto",new JoinDto());
        return "/member/join";
    }
    @GetMapping("/mypage")
    public String mypage(Model model) {
        //model.addAttribute("joinDto",new JoinDto());
        return "/member/mypage";
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

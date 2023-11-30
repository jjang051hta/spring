package com.jjang051.jpa.controller;

import com.jjang051.jpa.entity.Member02;
import com.jjang051.jpa.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @GetMapping("/join")
    public String join() {
        return "/member/join";
    }

    @PostMapping("/join")
    public String joinProcess(Member02 member) {
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Member02> memberList = memberService.getAllMember();
        model.addAttribute("memberList",memberList);
        return "/member/list";
    }


}

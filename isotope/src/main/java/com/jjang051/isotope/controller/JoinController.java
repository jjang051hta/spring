package com.jjang051.isotope.controller;

import com.jjang051.isotope.dto.JoinDto;
import com.jjang051.isotope.dto.MemberDto;
import com.jjang051.isotope.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Controller
@Slf4j
@RequestMapping("/member")
@RequiredArgsConstructor
public class JoinController {

    private final MemberService memberService;

    @GetMapping("/join")
    public String join(Model model) {
        model.addAttribute("memberDto",new MemberDto());
        return  "/join";
    }

    /*@PostMapping("/join")
    public String joinProcess(@Valid @ModelAttribute JoinDto joinDto,
                              BindingResult bindingResult, Model model) throws ParseException {

        log.info("joinDto.getBirth()==={}",joinDto.getBirth());

        if(joinDto.getAge()>100) {
            bindingResult.reject("ageError","너 살아는 있냐?");
        }
        if(joinDto.getName().contains("개새")) {
            bindingResult.reject("nameError","이름에 개새는 포함되면 안됩니다.");
        }
        if(joinDto.getProfile().isEmpty()) {
            model.addAttribute("joinDto", joinDto);
            bindingResult.addError(new FieldError("profileError","profile","이미지를 입력해 주세요."));
            return "/join";
        }
        if(bindingResult.hasErrors()) {
            model.addAttribute("joinDto", joinDto);
            return "/join";
        }
        return  "redirect:/isotope/main";
    }*/

    @PostMapping("/join")
    public String joinProcess(@ModelAttribute MemberDto memberDto) {
        int result = memberService.insertMember(memberDto);
        log.info("join=={}",result);
        return  "redirect:/member/login";
    }

    @GetMapping("/login")
    public String login() {
        return  "/login";
    }


    @GetMapping("/mypage")
    public String mypage() {
        return  "/mypage";
    }


}

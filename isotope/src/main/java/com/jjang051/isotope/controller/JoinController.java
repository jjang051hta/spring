package com.jjang051.isotope.controller;

import com.jjang051.isotope.dto.JoinDto;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/member")
public class JoinController {

    @GetMapping("/join")
    public String join(Model model) {
        model.addAttribute("joinDto",new JoinDto());
        return  "/join";
    }

    @PostMapping("/join")
    public String joinProcess(@Valid @ModelAttribute JoinDto joinDto,
                              BindingResult bindingResult, Model model) {
        log.info("password==={}",joinDto.getPassword());
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
    }

}

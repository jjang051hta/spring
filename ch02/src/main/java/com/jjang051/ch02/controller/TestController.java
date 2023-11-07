package com.jjang051.ch02.controller;

import com.jjang051.ch02.dto.SignupDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class TestController {
    @GetMapping("/")
    public String index(@RequestParam(required = true, defaultValue = "noname") String name,
                        Model model
                        ) {
        log.info("name==={}",name);
        model.addAttribute("name",name);
        return "index";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginProcess(@RequestParam(required = true) String name,
                               @RequestParam(required = true) String password
                               ) {
        log.info("name==={},password==={}",name,password);
        if(name.equals("jjang051") && password.equals("1234")){
            return "redirect:/";
        }
        return "redirect:/login";
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @PostMapping("/signup")
    @ResponseBody
    public SignupDto loginProcess(@ModelAttribute SignupDto signupDto) {
        log.info("userId==={},name==={},email==={},password==={}",
                signupDto.getUserId(),
                signupDto.getName(),
                signupDto.getEmail(),
                signupDto.getPassword()
        );

        /*SignupDto sendSignupDto = SignupDto.builder()
                .name(signupDto.getName())
                .userId(signupDto.getUserId())
                .email(signupDto.getEmail())
                .password(signupDto.getPassword())
                .build();
        return sendSignupDto;*/
        return SignupDto.builder()
                .name(signupDto.getName())
                .userId(signupDto.getUserId())
                .email(signupDto.getEmail())
                .password(signupDto.getPassword())
                .build();
    }
}

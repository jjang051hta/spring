package com.jjang051.board.controller;

import com.jjang051.board.dto.MailDto;
import com.jjang051.board.service.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Controller
@Slf4j
@RequestMapping("/mail")
public class MailController {

    private final MailService mailService;
    @GetMapping("/mail")
    public String mail() {
        return "/mail/mail";
    }
    @PostMapping("/send")
    public String send(@ModelAttribute MailDto mailDto) {
        mailService.sendMail(mailDto);
        return "redirect:/";
    }

    @PostMapping("/confirm")
    @ResponseBody
    public Map<String, Integer> confirm(String mail) {
        int randomNum = mailService.sendMailAuthEmail(mail);
        Map<String,Integer> resultMap = new HashMap<>();
        resultMap.put("confirmNumber",randomNum);
        return resultMap;
        //{confirmNumber:23435}
    }
}

package com.jjang051.outstargram.controller;

import com.jjang051.outstargram.dto.TestDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @GetMapping({"/","/index"})
    public String index() {
        return "index/index";
    }

    @PostMapping("/test")
    @ResponseBody
    public String test(TestDto testDto) {
        System.out.println("===="+testDto.getContents());
        return "aaa";
    }

}

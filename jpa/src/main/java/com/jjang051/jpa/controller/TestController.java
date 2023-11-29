package com.jjang051.jpa.controller;

import com.jjang051.jpa.entity.Board02;
import com.jjang051.jpa.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class TestController {

    private final BoardRepository boardRepository;


    @GetMapping("/")
    @ResponseBody
    public String index() {
        /*Board02 board02 = new Board02();
        board02.setSubject("jpa 사용중");
        board02.setContent("jpa 사용중입니다. 잘되나요?");
        */
        Board02 board02 = Board02.builder().subject("aaa").content("bbbbbbb").build();
        boardRepository.save(board02);
        return "index";
    }
}

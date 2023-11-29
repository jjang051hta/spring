package com.jjang051.jpa.controller;

import com.jjang051.jpa.entity.Board02;
import com.jjang051.jpa.repository.BoardRepository;
import com.jjang051.jpa.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private final BoardService boardService;
    @GetMapping("/")
    @ResponseBody
    public String index() {
        Board02 board02 = Board02.builder().subject("aaa").content("bbbbbbb").build();
        boardService.insertBoard(board02);
        return "index";
    }

    @GetMapping("/list")
    @ResponseBody
    public String list(Model model) {
        List<Board02> boardList = boardService.getAllBoard();
        model.addAttribute("boardList",boardList);
        log.info("{}",boardList.size());
        return "index";
    }

}

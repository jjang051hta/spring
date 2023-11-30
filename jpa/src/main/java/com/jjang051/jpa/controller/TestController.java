package com.jjang051.jpa.controller;

import com.jjang051.jpa.entity.Board02;
import com.jjang051.jpa.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private final BoardService boardService;

    @GetMapping("/")
    public String index() {
        return "/index";
    }
    @GetMapping("/insert")
    public String insert() {
        return "/insert";
    }

    @PostMapping("/insert")
    public String insertProcess(@ModelAttribute Board02 board02) {
        Board02 dbInsertBoard = Board02.builder()
                .subject(board02.getSubject())
                .content(board02.getContent())
                .build();
        boardService.insertBoard(dbInsertBoard);
        return "redirect:/list";
    }


    @GetMapping("/list")
    public String list(Model model) {
        List<Board02> boardList = boardService.getAllBoard();
        model.addAttribute("boardList",boardList);
        return "/list";
    }

}

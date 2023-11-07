package com.jjang051.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
    @GetMapping("/list")
    public String list(Model model) {
        //model.addAttribute("title","list");
        return  "/board/list";
    }

    @GetMapping("/write")
    public String write(Model model) {
        model.addAttribute("title","write");
        return  "/board/write";
    }
}

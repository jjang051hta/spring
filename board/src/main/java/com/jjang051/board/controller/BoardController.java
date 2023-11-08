package com.jjang051.board.controller;

import com.jjang051.board.dto.BoardDto;
import com.jjang051.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Slf4j
public class BoardController {


    /*@Autowired
    BoardService boardService;*/

    private final BoardService boardService;

    @GetMapping("/list")
    public String list(Model model) {
        List<BoardDto> boardList = boardService.getAllBoard();
        /*List<BoardDto> boardList = new ArrayList<>();
        boardList.add(BoardDto.builder()
                        .name("장성호")
                        .title("제목01")
                        .content("내용01")
                .build());
        boardList.add(BoardDto.builder()
                .name("장동건")
                .title("제목02")
                .content("내용02")
                .build());*/

        model.addAttribute("title","list");
        model.addAttribute("boardList",boardList);
        return  "/board/list";
    }

    @GetMapping("/write")
    public String write(Model model) {
        model.addAttribute("title","write");
        return  "/board/write";
    }

    @GetMapping("/read")
    public String getOneBoard(String name) {
        log.info("getOneBoard==={}",name);
        return  "/board/read";
    }

}

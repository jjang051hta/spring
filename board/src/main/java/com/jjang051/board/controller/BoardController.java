package com.jjang051.board.controller;

import com.jjang051.board.dto.BoardDto;
import com.jjang051.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("boardList",boardList);
        return  "/board/list";
    }

    @GetMapping("/write")
    public String write(Model model) {
        //model.addAttribute("title","write");
        model.addAttribute("boardDto", new BoardDto());
        return  "/board/write";
    }

    @PostMapping("/write")
    public String writeProcess(@Valid @ModelAttribute BoardDto boardDto,
                               BindingResult bindingResult,
                               Model model
                               ) {
        if(bindingResult.hasErrors()){
            model.addAttribute("boardDto", boardDto);
            log.info("boardDto=={}",boardDto.toString());
            return "/board/write";
        }
        boardService.insertBoard(boardDto);
        return "redirect:/";
    }


    @GetMapping("/view/{id}")
    public String getOneBoard(@PathVariable int id) {
        //query작성하고
        // 내용 출력하기...
        log.info("getOneBoard==={}",id);
        return  "/board/view";
    }

}

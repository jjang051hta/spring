package com.jjang051.jpa.controller;

import com.jjang051.jpa.dto.BoardDto;
import com.jjang051.jpa.entity.Board02;
import com.jjang051.jpa.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/")
    public String index() {
        return "/index";
    }
    @GetMapping("/insert")
    public String insert() {
        return "/board/insert";
    }

    @PostMapping("/insert")
    public String insertProcess(@ModelAttribute BoardDto boardDto) {
        Board02 dbInsertBoard = Board02.builder()
                .subject(boardDto.getSubject())
                .content(boardDto.getContent())
                .createDate(LocalDateTime.now())
                .build();
        boardService.insertBoard(dbInsertBoard);
        return "redirect:/board/list";
    }

    /*@GetMapping("/list")
    public String list(Model model) {
        List<BoardDto> boardList =boardService.getAllBoard();
        model.addAttribute("boardList",boardList);
        return "/board/list";
    }*/


//    @GetMapping("/list")
//    public String list02(Model model, @RequestParam(value = "page", required = true, defaultValue = "0") int page) {
//        Page<Board02> boardList = boardService.getAllPageBoard(page);
//        model.addAttribute("boardList",boardList);
//        return "/board/list";
//    }

    @GetMapping("/list")
    public String list02(Model model) {
        List<Board02> boardList = boardService.getAllBoard();
        model.addAttribute("boardList",boardList);
        return "/board/list";
    }

    @GetMapping("/list02")
    public String pageList(Model model,
                           @RequestParam(value="page", required = true, defaultValue = "0") int page) {
        Page<Board02> pagination = boardService.getAllPageBoard(page);
        log.info("pageBoardList.getTotalPages()==={}",pagination.getTotalPages());
        log.info(pagination.toString());
        List<Board02> boardList = pagination.getContent();
        model.addAttribute("boardList",boardList);
        model.addAttribute("pagination",pagination);

        return "/board/list";
    }


    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        log.info("id==={}",id);
        BoardDto board = boardService.getBoard(id);
        log.info("commentList==={}",board.getCommentList().size());
        model.addAttribute("board",board);
        return "/board/view";
    }
}

package com.jjang051.jpa.controller;

import com.jjang051.jpa.entity.Board02;
import com.jjang051.jpa.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class BoardRestController {
    private final BoardService boardService;
    @GetMapping("/viewInfo/{id}")
    public Map<String,Object> view(@PathVariable int id, Model model) {
        //log.info("id==={}",id);
        //Board02 board = boardService.getBoard(id);
        Board02 board = boardService.getBoardDsl(id);
        //log.info("commentList==={}",board.getCommentList().size());
        //model.addAttribute("board",board);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("result",board);
        return resultMap;
    }
}

package com.jjang051.board.controller;

import com.jjang051.board.dto.BoardDto;
import com.jjang051.board.dto.ModalDto;
import com.jjang051.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Slf4j
public class BoardController {


//    @Autowired
//    BoardService boardService;

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
        BoardDto boardDto = BoardDto.builder().build();
        model.addAttribute("boardDto", boardDto);
        return  "/board/write";
    }

    @PostMapping("/write")
    public String writeProcess(@Valid @ModelAttribute BoardDto boardDto,
                               BindingResult bindingResult,
                               Model model,
                               RedirectAttributes redirectAttributes
                               ) {
        if(bindingResult.hasErrors()){
            model.addAttribute("boardDto", boardDto);
            log.info("boardDto=={}",boardDto.toString());
            return "/board/write";
        }
        int result = boardService.insertBoard(boardDto);
        if(result>0){
            ModalDto modalDto = ModalDto.builder()
                    .isState("success")
                    .title("글쓰기")
                    .msg("글이 입력되었습니다.")
                    .build();
            redirectAttributes.addFlashAttribute("modalDto",modalDto);
        }
        //redirectAttributes.addFlashAttribute("name",boardDto.getName());
        //redirectAttributes.addAttribute("age",20);

        return "redirect:/";
    }


    @GetMapping("/view/{id}")
    public String getOneBoard(@PathVariable int id) {
        //query작성하고
        // 내용 출력하기...
        log.info("getOneBoard==={}",id);
        return  "/board/view";
    }
    @GetMapping("/delete/{id}")
    @ResponseBody
    public Map<String,String> deleteBoard(@PathVariable int id) {
        log.info("ajax로 넘어언 id==={}",id);
        int result = boardService.deleteBoard(id);
        Map<String, String> resultMap = new HashMap<>();
        if(result>0){
            resultMap.put("isDelete","ok");
        } else {
            resultMap.put("isDelete", "fail");
        }
        return resultMap;
    }
}

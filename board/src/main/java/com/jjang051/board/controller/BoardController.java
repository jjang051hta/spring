package com.jjang051.board.controller;

import com.jjang051.board.dto.BoardDto;
import com.jjang051.board.dto.Criteria;
import com.jjang051.board.dto.ModalDto;
import com.jjang051.board.dto.ToastDto;
import com.jjang051.board.service.BoardService;
import com.jjang051.board.utils.PaginationMaker;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Slf4j
public class BoardController {


//    @Autowired
//    BoardService boardService;

    private final BoardService boardService;

    private final PaginationMaker paginationMaker;

    /*@GetMapping("/list")
    public String list(Model model,
                       @RequestParam(required = false) String category,
                       @RequestParam(required = false) String searchTxt) {
        log.info("category==={}, searchTxt==={}",category, searchTxt);
        List<BoardDto> boardList = boardService.getAllBoard(category,searchTxt);
        model.addAttribute("boardList",boardList);
        return  "/board/list";
    }*/
    @GetMapping("/list")
    public String list(Model model, @ModelAttribute Criteria criteria) {
        List<BoardDto> boardList = boardService.getAllBoard(criteria);
        //paginationMaker.setPageBlock(7);
        paginationMaker.setCriteria(criteria);
        paginationMaker.setTotal(boardService.getTotalCount());
        model.addAttribute("boardList",boardList);
        model.addAttribute("paginationMaker",paginationMaker);
        log.info("paginationMaker==={}",paginationMaker.toString());
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
                    .msg("글이 입력되었습니다.")
                    .build();
            redirectAttributes.addFlashAttribute("modalDto",modalDto);
        }
        //redirectAttributes.addFlashAttribute("name",boardDto.getName());
        //redirectAttributes.addAttribute("age",20);

        return "redirect:/";
    }


    /*@GetMapping("/view/{id}")
    @ResponseBody
    public Map<String, Object> getOneBoard(@PathVariable int id) {
        log.info("getOneBoard==={}",id);
        BoardDto boardDto = boardService.getOneBoard(id);
        Map<String, Object> resultMap = new HashMap<>();
        if(boardDto!=null){
            resultMap.put("isState","ok");
            resultMap.put("viewData",boardDto);
        } else {
            resultMap.put("isState", "fail");
            resultMap.put("viewData",null);
        }
        return  resultMap;
    }*/

    @GetMapping("/view/{id}")
    public String getOneBoard(@PathVariable int id,Model model) {
        log.info("getOneBoard==={}",id);
        BoardDto boardDto = boardService.getOneBoard(id);
        model.addAttribute("boardDto",boardDto);
        return  "/board/view";
    }

    @GetMapping("/modify/{id}")
    public String modifyBoard(@PathVariable int id,Model model) {
        log.info("getOneBoard==={}",id);
        BoardDto boardDto = boardService.getOneBoard(id);
        model.addAttribute("boardDto",boardDto);
        return  "/board/modify";
    }

    @PostMapping("/modify")
    public String modifyProcessBoard(@Valid @ModelAttribute BoardDto boardDto,
                                     BindingResult bindingResult,
                                     Model model,
                                     RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("boardDto", boardDto);
            return "/board/modify";
        }
        int result = boardService.modifyBoard(boardDto);
        if(result>0){
            ModalDto modalDto = ModalDto.builder()
                    .isState("success")
                    .title("글수정")
                    .msg("글이 수정되었습니다.")
                    .build();
            redirectAttributes.addFlashAttribute("modalDto",modalDto);
        }
        return "redirect:/";
    }

    @DeleteMapping("/delete/{id}")
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

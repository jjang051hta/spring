package com.jjang051.todo.controller;

import com.jjang051.todo.dto.TodoDto;
import com.jjang051.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;
    @GetMapping({"/","/index"})
    public String index() {
        return "/todo/index";
    }
    @PostMapping("/insert")
    @ResponseBody
    public List<TodoDto> insertTodo(@ModelAttribute TodoDto todoDto) {
        log.info("todoDto==={}",todoDto.toString());
        todoService.insertTodo(todoDto);
        List<TodoDto> todolist = todoService.getPickedDateTodo(todoDto);
        return todolist;
    }
}

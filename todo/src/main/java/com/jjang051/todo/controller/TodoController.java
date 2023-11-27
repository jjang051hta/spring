package com.jjang051.todo.controller;

import com.jjang051.todo.dto.TodoDto;
import com.jjang051.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<TodoDto> todoList = todoService.insertTodo(todoDto);
        return todoList;
    }

    @PostMapping("/list")
    @ResponseBody
    public List<TodoDto> getPickedDateTodo(@ModelAttribute TodoDto todoDto) {
        List<TodoDto> todolist = todoService.getPickedDateTodo(todoDto);
        return todolist;
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public Map<String,Integer> deleteTodo(@ModelAttribute TodoDto todoDto) {
        int result = todoService.deleteTodo(todoDto);
        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put("isDelete",result);
        return resultMap;
    }
}

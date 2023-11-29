package com.jjang051.todo.controller;

import com.jjang051.todo.dto.CalendarDto;
import com.jjang051.todo.dto.TodoDto;
import com.jjang051.todo.service.CalendarService;
import com.jjang051.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/calendar")
@RequiredArgsConstructor
public class CalendarController {

    private final CalendarService calendarService;

    @GetMapping("/")
    public String calendar(Model model) {
//        List<CalendarDto> todo = new ArrayList<>();
//        todo.add(TodoDto.builder().id("aaa").start("2023-11-28").title("밥먹고 합시다.").build());
//        todo.add(TodoDto.builder().id("bbb").start("2023-11-29").title("밥먹고 합시다.").build());
//        todo.add(TodoDto.builder().id("ccc").start("2023-11-15").title("밥먹고 합시다.").build());
//
//        model.addAttribute("todo",todo);
        return "/todo/calendar";
    }
    @GetMapping("/form")
    public String calendarForm() {
        return "/todo/calendarForm";
    }

    @PostMapping("/todo")
    public String calendarTodo(@ModelAttribute CalendarDto calendarDto) {
        return "/todo/calendar";
    }

}

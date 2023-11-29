package com.jjang051.todo.controller;

import com.jjang051.todo.dto.CalendarDto;
import com.jjang051.todo.dto.TodoDto;
import com.jjang051.todo.service.CalendarService;
import com.jjang051.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/calendar")
@RequiredArgsConstructor
public class CalendarController {

    private final CalendarService calendarService;

    @GetMapping("/")
    public String calendar(Model model) {
        List<CalendarDto> calendarDtoList =
                calendarService.getAllCalendar();
        model.addAttribute("calendarDtoList",calendarDtoList);
        return "/todo/calendar";
    }
    @GetMapping("/form")
    public String calendarForm() {
        return "/todo/calendarForm";
    }

    @PostMapping("/todo")
    public String calendarTodo(@ModelAttribute CalendarDto calendarDto) {
        log.info("calendarDto.toString()===={}",calendarDto.toString());
        CalendarDto dbInserCalendarDto = CalendarDto.builder()
                .id(calendarDto.getId())
                .start(calendarDto.getStart()+" "+calendarDto.getStartTime())
                .end(calendarDto.getEnd()+" "+calendarDto.getEndTime())
                .allDay(calendarDto.isAllDay())
                .title(calendarDto.getTitle())
                .url(calendarDto.getUrl())
                .backgroundColor(calendarDto.getBackgroundColor())
                .borderColor(calendarDto.getBackgroundColor())
                .build();
        calendarService.insertCalendar(dbInserCalendarDto);
        return "redirect:/calendar/";
    }

    @PostMapping("/modalTodo")
    @ResponseBody
    public Map<String,String> modalTodo(@ModelAttribute CalendarDto calendarDto) {
        log.info("calendarDto.toString()===={}",calendarDto.toString());
        CalendarDto dbInserCalendarDto = CalendarDto.builder()
                .id(calendarDto.getId())
                .start(calendarDto.getStart()+" "+calendarDto.getStartTime())
                .end(calendarDto.getEnd()+" "+calendarDto.getEndTime())
                .allDay(calendarDto.isAllDay())
                .title(calendarDto.getTitle())
                .url(calendarDto.getUrl())
                .backgroundColor(calendarDto.getBackgroundColor())
                .borderColor(calendarDto.getBackgroundColor())
                .build();
        int result = calendarService.insertCalendar(dbInserCalendarDto);
        Map<String, String > resultMap = new HashMap<>();
        resultMap.put("isInsert","ok");
        return resultMap;
    }
}

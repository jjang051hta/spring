package com.jjang051.todo.service;

import com.jjang051.todo.dao.CalendarDao;
import com.jjang051.todo.dao.TodoDao;
import com.jjang051.todo.dto.CalendarDto;
import com.jjang051.todo.dto.TodoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CalendarService {
    private final CalendarDao calendarDao;

    @Transactional
    public int insertCalendar(CalendarDto calendarDto) {
        int result  = calendarDao.insertCalendar(calendarDto);
        return result;
    }

    @Transactional
    public List<CalendarDto> getAllCalendar() {
        List<CalendarDto> calendarDtoList  = calendarDao.getAllCalendar();
        return calendarDtoList;
    }
}

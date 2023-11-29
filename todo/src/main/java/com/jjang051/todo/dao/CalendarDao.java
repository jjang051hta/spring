package com.jjang051.todo.dao;

import com.jjang051.todo.dto.CalendarDto;
import com.jjang051.todo.dto.TodoDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CalendarDao {
    int insertCalendar(CalendarDto CalendarDto);
    List<CalendarDto> getAllCalendar();
}

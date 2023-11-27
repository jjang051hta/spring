package com.jjang051.todo.dao;

import com.jjang051.todo.dto.TodoDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoDao {
    int insertTodo(TodoDto todoDto);
}

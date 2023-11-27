package com.jjang051.todo.service;

import com.jjang051.todo.dao.TodoDao;
import com.jjang051.todo.dto.TodoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoDao todoDao;
    public int insertTodo(TodoDto todoDto) {
        int result  = todoDao.insertTodo(todoDto);
        return result;
    }

    public List<TodoDto> getPickedDateTodo(TodoDto todoDto) {
        List<TodoDto> todoList  = todoDao.getPickedDateTodo(todoDto);
        return todoList;
    }

}

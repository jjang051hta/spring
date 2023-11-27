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


    @Transactional
    public List<TodoDto> insertTodo(TodoDto todoDto) {
        int result  = todoDao.insertTodo(todoDto);
        List<TodoDto> todoList = getPickedDateTodo(todoDto);
        return todoList;
    }

    public List<TodoDto> getPickedDateTodo(TodoDto todoDto) {
        List<TodoDto> todoList  = todoDao.getPickedDateTodo(todoDto);
        return todoList;
    }

    public int deleteTodo(TodoDto todoDto) {
        int result  = todoDao.deleteTodo(todoDto);
        return result;
    }


}

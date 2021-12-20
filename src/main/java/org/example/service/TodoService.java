package org.example.service;

import org.example.entities.TodoEntities;

import java.util.List;

public interface TodoService {

    public void addTodo(TodoEntities todoEntities);
    public List<TodoEntities> getAllTodo();
    public  void deleteTodo(Integer todoId);
    public TodoEntities getTodo(int todoId);
    public TodoEntities updateTodo(TodoEntities todoEntities);
}

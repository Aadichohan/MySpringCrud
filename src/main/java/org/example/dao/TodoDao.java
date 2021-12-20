package org.example.dao;

import org.example.entities.TodoEntities;

import java.util.List;

public interface TodoDao {

    public void addTodo(TodoEntities todoEntities);

    public List<TodoEntities> getAllTodo();

    public void deleteTodo(Integer employeeId);
    public TodoEntities getTodo(int todoId);
    public TodoEntities updateTodo(TodoEntities todoEntities);
}

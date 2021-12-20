package org.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;



import org.example.dao.TodoDao;
import org.example.entities.TodoEntities;
@Service
@Transactional
public class TodoServiceImpl implements TodoService{
    @Autowired
    private TodoDao todoDao;

    @Override
    @Transactional
    public void addTodo(TodoEntities todoEntities) {
      todoDao.addTodo(todoEntities);
    }
    @Override
    @Transactional
    public List<TodoEntities> getAllTodo(){
        return todoDao.getAllTodo();
    }

    @Override
    @Transactional
    public void deleteTodo(Integer todoId){
        todoDao.deleteTodo(todoId);
    }

    @Override
    @Transactional
    public  TodoEntities getTodo(int todoId){
      return  todoDao.getTodo(todoId);
    }

    @Override
    @Transactional
    public TodoEntities updateTodo(TodoEntities todoEntities) {
        return todoDao.updateTodo(todoEntities);
    }
   public void setTodoDao(){
        this.todoDao = todoDao ;
   }
}

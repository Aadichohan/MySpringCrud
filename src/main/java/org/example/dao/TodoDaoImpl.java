package org.example.dao;

import org.example.entities.TodoEntities;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoDaoImpl implements TodoDao{
    @Autowired
    SessionFactory sessionFactory;
    public void addTodo(TodoEntities todoEntities){
        sessionFactory.getCurrentSession().saveOrUpdate(todoEntities);
    }

    public List<TodoEntities> getAllTodo(){
      return sessionFactory.getCurrentSession().createQuery("from TodoEntities")
              .list();
    }
    @Override
    public void deleteTodo(Integer todoId){
        TodoEntities todoEntities = (TodoEntities) sessionFactory.getCurrentSession()
                .load(TodoEntities.class, todoId);
        if(null != todoId){
             this.sessionFactory.getCurrentSession().delete(todoEntities);
        }

    }

    public TodoEntities getTodo(int todoId){
      return (TodoEntities) sessionFactory.getCurrentSession()
              .get(TodoEntities.class, todoId);
    }

    @Override
    public TodoEntities updateTodo(TodoEntities todoEntities){
      sessionFactory.getCurrentSession().update(todoEntities);
      return  todoEntities;
    }
}

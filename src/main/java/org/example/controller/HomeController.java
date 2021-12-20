package org.example.controller;


import org.example.dao.TodoDaoImpl;
import org.example.entities.TodoEntities;
import org.example.service.TodoService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {
    private  static  final Logger logger = Logger.getLogger(HomeController.class);
    public HomeController(){
        System.out.println("Home Controller");
    }
    @Autowired
   private TodoService todoService;
    //    @RequestMapping(value = "/home", method = RequestMethod.GET)
    @RequestMapping(value = "/")
    public ModelAndView listTodo(ModelAndView model){
     List<TodoEntities> listTodo = todoService.getAllTodo();
     model.addObject("ListTodo", listTodo);
     model.setViewName("home");
     return  model;
    }
    @RequestMapping(value = "/addTodo", method = RequestMethod.GET)
    public ModelAndView addTodo(ModelAndView model){
        TodoEntities todo = new TodoEntities();
        model.addObject("todo", todo);
        model.setViewName("TodoForm");
        return model;
    }

    @RequestMapping(value = "/saveTodo", method = RequestMethod.POST)
    public ModelAndView saveTodo(@ModelAttribute TodoEntities todo){
        if(todo.getId() == 0){
        todoService.addTodo(todo);
        }
        else{
            todoService.updateTodo(todo);
        }
        return  new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/deleteTodo", method = RequestMethod.GET)
    public ModelAndView deleteTodo(HttpServletRequest request){
        int todoId = Integer.parseInt(request.getParameter("id"));
        todoService.deleteTodo(todoId);
        return new ModelAndView("redirect:/");
    }
    @RequestMapping(value = "/editTodo", method = RequestMethod.GET)
    public ModelAndView editTodo(HttpServletRequest request){
        int todoId = Integer.parseInt(request.getParameter("id"));
        TodoEntities todoEntities = todoService.getTodo(todoId);
        ModelAndView model =  new ModelAndView("TodoForm");
        model.addObject("todo", todoEntities);
        return  model;
    }
}

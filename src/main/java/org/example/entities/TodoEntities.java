package org.example.entities;

import javax.persistence.*;

@Entity
@Table(name = "todoList")
public class TodoEntities {
    @Id
//    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    @Column
    private String todoTitle;
    @Column
    private String todoEmail;
    @Column
    private String todoDetail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public TodoEntities(String todoTitle, String todoContent, Date todoDate) {
//        this.todoTitle = todoTitle;
//        this.todoDate = todoDate;
//        this.todoContent = todoContent;
//    }
//
//    public TodoEntities() {
//        super();
//    }

    public String getTodoTitle() {
        return todoTitle;
    }
    public void setTodoTitle(String todoTitle) {
        this.todoTitle = todoTitle;
    }

    public String getTodoEmail() {
        return todoEmail;
    }
    public void setTodoEmail(String todoEmail) {
        this.todoEmail = todoEmail;
    }


    public String getTodoDetail() {
        return todoDetail;
    }
    public void setTodoDetail(String todoDetail) {
        this.todoDetail = todoDetail;
    }



}


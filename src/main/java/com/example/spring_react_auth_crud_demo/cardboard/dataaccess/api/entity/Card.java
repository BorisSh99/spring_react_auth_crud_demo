package com.example.spring_react_auth_crud_demo.cardboard.dataaccess.api.entity;

import com.example.spring_react_auth_crud_demo.cardboard.common.api.datatype.Label;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Card {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private Label label;
    private LocalDate dueDate;
    private String assignedUser;

    public Card() {}

    public Card(String title, String description, Label label, LocalDate dueDate, String assignedUser) {
        this.title = title;
        this.description = description;
        this.label = label;
        this.dueDate = dueDate;
        this.assignedUser = assignedUser;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(String assignedUser) {
        this.assignedUser = assignedUser;
    }

    @Override
    public  String toString() {
        return "Card #" + id.toString() + ": " + title;
    }

}

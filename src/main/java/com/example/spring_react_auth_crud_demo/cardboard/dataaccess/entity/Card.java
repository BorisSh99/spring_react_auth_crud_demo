package com.example.spring_react_auth_crud_demo.cardboard.dataaccess.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Card {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name="label_id", nullable=false)
    @JsonIgnore
    private Label label;
    private LocalDate dueDate;

    public Card() {}

    public Card(String title, String description, Label label, LocalDate dueDate) { //TODO deleted addCard
        this.title = title;
        this.description = description;
        this.label = label;
        this.dueDate = dueDate;
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

    @Override
    public  String toString() {
        return "Card #" + id.toString() + ": " + title;
    }

}

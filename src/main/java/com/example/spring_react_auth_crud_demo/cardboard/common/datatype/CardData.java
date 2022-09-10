package com.example.spring_react_auth_crud_demo.cardboard.common.datatype;

import java.time.LocalDate;

public class CardData {

    private String title;
    private String description;
    private String labelName;
    private LocalDate dueDate;

    public CardData() {}

    public CardData(String title, String description, String labelName, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.labelName = labelName;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLabelName() {
        return labelName;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate == null ? LocalDate.now() : dueDate;
    }

    @Override
    public String toString() {
        return "CardData{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", labelName='" + labelName + '\'' +
                ", dueDate='" + dueDate + '\'' +
                '}';
    }
}

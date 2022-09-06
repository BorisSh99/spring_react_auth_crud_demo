package com.example.spring_react_auth_crud_demo.cardboard.common.api.datatype;

import java.time.LocalDate;

public class CardData {

    private String title;
    private String description;
    private String labelName;
    private String dueDate;

    public CardData(String title, String description, String labelName, String dueDate) {
        this.title = title;
        this.description = description;
        this.labelName = labelName;
        this.dueDate = dueDate;
    }

    public CardData(String title, String description, String labelName) {
        this.title = title;
        this.description = description;
        this.labelName = labelName;
        this.dueDate = LocalDate.now().toString();
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

    public String getDueDate() {
        return dueDate;
    }
}

package com.example.spring_react_auth_crud_demo.cardboard.common.exception;

public class LabelNotFoundException extends Exception {

    public static final String LABEL_WITH_ID_NOT_FOUND_MESSAGE = "Could not find label with ID %d.";

    private final Long id;

    public LabelNotFoundException(Long id) {
        super(String.format(LABEL_WITH_ID_NOT_FOUND_MESSAGE, id));
        this.id = id;
    }
}

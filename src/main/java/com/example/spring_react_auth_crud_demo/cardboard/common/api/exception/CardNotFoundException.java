package com.example.spring_react_auth_crud_demo.cardboard.common.api.exception;

public class CardNotFoundException extends Exception {

    public static final String CARD_WITH_ID_NOT_FOUND_MESSAGE = "Could not find card with ID %d.";

    private final Long id;

    public CardNotFoundException(Long id) {
        super(String.format(CARD_WITH_ID_NOT_FOUND_MESSAGE, id));
        this.id = id;
    }

}

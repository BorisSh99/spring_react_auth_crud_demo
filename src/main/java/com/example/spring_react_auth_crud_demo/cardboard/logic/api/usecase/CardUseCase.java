package com.example.spring_react_auth_crud_demo.cardboard.logic.api.usecase;

import com.example.spring_react_auth_crud_demo.cardboard.dataaccess.api.entity.Label;
import com.example.spring_react_auth_crud_demo.cardboard.common.api.exception.CardNotFoundException;
import com.example.spring_react_auth_crud_demo.cardboard.dataaccess.api.entity.Card;

import java.time.LocalDate;
import java.util.List;

public interface CardUseCase {

    /**
     * Finds all existing cards.
     *
     * @return a list of cards
     */
    List<Card> getAllCards();

    /**
     * Finds an existing card.
     *
     * @param id             the id of the card, must not be null
     * @return the card, if exists, null otherwise
     */
    Card findCardById(Long id) throws CardNotFoundException;

    /**
     * Creates a card with the given data.
     *
     * @param title          the card's title; must not be null
     * @param description    the card's description; must contain text
     * @param label          the card's label; of type Label
     * @param dueDate        the card's due date
     * @return the created card
     */
    Card createCard(String title, String description, Label label, LocalDate dueDate);


    /**
     * Deletes the card with the given ID.
     *
     * @param id             the card's technical ID; must be the ID of an existing card
     * @throws CardNotFoundException in case the card could not be found
     */
    void deleteCardById(Long id) throws CardNotFoundException;


    /**
     * Deletes all cards.
     */
    void deleteAll();

    /**
     * Finds all existing unique labels.
     *
     * @return a list of labels
     */
    List<Label> getAllLabels();


}

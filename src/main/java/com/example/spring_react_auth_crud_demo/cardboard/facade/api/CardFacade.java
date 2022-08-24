package com.example.spring_react_auth_crud_demo.cardboard.facade.api;

import com.example.spring_react_auth_crud_demo.cardboard.dataaccess.api.entity.Label;
import com.example.spring_react_auth_crud_demo.cardboard.common.api.exception.CardNotFoundException;
import com.example.spring_react_auth_crud_demo.cardboard.dataaccess.api.entity.Card;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CardFacade {
    /**
     * Finds all available cards.
     *
     * @return the found cards or an empty list if none were found
     */
    List<Card> getCards();

    /**
     * Finds the card with the given ID.
     *
     * @param id the card's technical ID
     * @return the found card
     * @throws CardNotFoundException in case the card could not be found
     */
    Card getCardById(Long id) throws CardNotFoundException;

    /**
     * Creates a card with the given Card object.
     *
     * @param card the card to be created; must not be null
     * @return the created card
     */
    Card createCard(Card card);

    /**
     * Deletes the card with the given ID.
     *
     * @param id the card's technical ID
     * @throws CardNotFoundException in case the card could not be found
     */
    void deleteCardById(Long id) throws CardNotFoundException;

    /**
     * Finds all labels.
     *
     * @return a list of labels
     */
    List<Label> getLabels();

    Label getLabelByName(String name);
    Label createLabel(Label label);
    void deleteLabelByName(String name);

}

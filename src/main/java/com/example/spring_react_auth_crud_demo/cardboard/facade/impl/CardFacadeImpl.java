package com.example.spring_react_auth_crud_demo.cardboard.facade.impl;

import com.example.spring_react_auth_crud_demo.cardboard.common.api.datatype.Label;
import com.example.spring_react_auth_crud_demo.cardboard.common.api.exception.CardNotFoundException;
import com.example.spring_react_auth_crud_demo.cardboard.dataaccess.api.entity.Card;
import com.example.spring_react_auth_crud_demo.cardboard.facade.api.CardFacade;
import com.example.spring_react_auth_crud_demo.cardboard.logic.api.usecase.CardUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/cardboard")
@CrossOrigin
public class CardFacadeImpl implements CardFacade {

    private final CardUseCase cardUseCase;

    @Autowired
    public CardFacadeImpl(CardUseCase cardUseCase) {
        this.cardUseCase = cardUseCase;
    }

    @GetMapping
    @Override
    public List<Card> getCards() {
        return cardUseCase.getAllCards();
    }

    @GetMapping("/{id}")
    @Override
    public Card getCardById(@PathVariable("id") Long id) throws CardNotFoundException {
        return cardUseCase.findCardById(id);
    }

    @PostMapping
    @Override
    public Card createCard(@RequestBody Card card) {
        // check preconditions
        Assert.notNull(card, "Parameter 'card' must not be null!");

        return cardUseCase.createCard(card.getTitle(), card.getDescription(), card.getLabel(), card.getDueDate());
    }

    @DeleteMapping("/{id}")
    @Override
    public void deleteCardById(@PathVariable("id") Long id) throws CardNotFoundException {
        cardUseCase.deleteCardById(id);
    }

    @GetMapping("/labels")
    public List<Label> getLabels() {
        return cardUseCase.getAllLabels();
    }
}

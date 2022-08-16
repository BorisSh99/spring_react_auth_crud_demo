package com.example.spring_react_auth_crud_demo.cardboard.logic.impl.usecase;

import com.example.spring_react_auth_crud_demo.cardboard.common.api.datatype.Label;
import com.example.spring_react_auth_crud_demo.cardboard.dataaccess.api.entity.Card;
import com.example.spring_react_auth_crud_demo.cardboard.dataaccess.api.repo.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class CardUseCaseImpl {  // TODO Throw exception instead of returning null + create API interface

    private final CardRepository cardRepo;

    @Autowired
    public CardUseCaseImpl(CardRepository cardRepo) {
        this.cardRepo = cardRepo;
    }

    public List<Card> getAllCards() {
        return cardRepo.findAll();
    }

    public Card findCardById(Long id) {
        return cardRepo.findById(id).orElse(null);
    }

    public Card createCard(String title, String description, Label label, LocalDate dueDate) {

        // create a new card as plain Java object
        Card card = new Card(title, description, label, dueDate);

        // store entity in DB
        return cardRepo.save(card);
    }

    public void deleteCardById(long id) {
        // make sure the card to be deleted exists (in future throw exception if not) and also load the card
        Card card = findCardById(id);

        // delete object from DB
        cardRepo.delete(card);
    }

    public void deleteAll() {
        cardRepo.deleteAll();
    }

    public List<Label> getAllLabels() {
        return cardRepo.findAllLabels();
    }

}

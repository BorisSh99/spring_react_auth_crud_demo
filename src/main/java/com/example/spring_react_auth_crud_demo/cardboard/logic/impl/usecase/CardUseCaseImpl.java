package com.example.spring_react_auth_crud_demo.cardboard.logic.impl.usecase;

import com.example.spring_react_auth_crud_demo.cardboard.common.api.datatype.Label;
import com.example.spring_react_auth_crud_demo.cardboard.common.api.exception.CardNotFoundException;
import com.example.spring_react_auth_crud_demo.cardboard.dataaccess.api.entity.Card;
import com.example.spring_react_auth_crud_demo.cardboard.dataaccess.api.repo.CardRepository;
import com.example.spring_react_auth_crud_demo.cardboard.logic.api.usecase.CardUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

@Component
public class CardUseCaseImpl implements CardUseCase {

    private final CardRepository cardRepository;

    @Autowired
    public CardUseCaseImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;

        //MOCK DATA
        Label label1 = new Label("Label1");
        Label label2 = new Label("Label2");
        Label label3 = new Label("Label3");

        this.cardRepository.save(new Card("Title1", "Description1", label1, LocalDate.of(2022, 8, 16)));
        this.cardRepository.save(new Card("Title2", "Description2", label1, LocalDate.of(2022, 4, 5)));
        this.cardRepository.save(new Card("Title3", "Description3", label2, LocalDate.of(2022, 3, 4)));

    }

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public Card findCardById(Long id) throws CardNotFoundException {
        // check preconditions
        Assert.notNull(id, "Parameter 'id' must not be null");

        return cardRepository.findById(id).orElseThrow(() -> new CardNotFoundException(id));
    }

    @Override
    public Card createCard(String title, String description, Label label, LocalDate dueDate) {
        // check preconditions
        Assert.notNull(title, "Parameter 'title' must not be null!");
        Assert.notNull(description, "Parameter 'description' must contain text!");
        Assert.notNull(label, "Parameter 'label' must not be null!");

        // create a new card as plain Java object
        Card card = new Card(title, description, label, dueDate);

        // store entity in DB
        return cardRepository.save(card);
    }

    @Override
    public void deleteCardById(Long id) throws CardNotFoundException {
        // check preconditions
        // make sure the card to be deleted exists (throw exception if not) and also load the card
        Card card = findCardById(id);

        // delete object from DB
        cardRepository.delete(card);
    }

    @Override
    public void deleteAll() {
        cardRepository.deleteAll();
    }

    @Override
    public List<Label> getAllLabels() {
        return cardRepository.findAllLabels();
    }

}

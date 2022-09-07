package com.example.spring_react_auth_crud_demo.cardboard.logic.usecase;

import com.example.spring_react_auth_crud_demo.cardboard.common.exception.CardNotFoundException;
import com.example.spring_react_auth_crud_demo.cardboard.dataaccess.entity.Card;
import com.example.spring_react_auth_crud_demo.cardboard.dataaccess.entity.Label;
import com.example.spring_react_auth_crud_demo.cardboard.dataaccess.repository.CardRepository;
import com.example.spring_react_auth_crud_demo.cardboard.dataaccess.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

@Service
public class CardboardUseCase {

    private final LabelRepository labelRepository;
    private final CardRepository cardRepository;

    @Autowired
    public CardboardUseCase(LabelRepository labelRepository, CardRepository cardRepository) {
        this.labelRepository = labelRepository;
        this.cardRepository = cardRepository;
    }

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Card findCardById(Long id) throws CardNotFoundException {
        // check preconditions
        Assert.notNull(id, "Parameter 'id' must not be null");

        return cardRepository.findById(id).orElseThrow(() -> new CardNotFoundException(id));
    }

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

    public void deleteCardById(Long id) throws CardNotFoundException {
        // check preconditions
        // make sure the card to be deleted exists (throw exception if not) and also load the card
        Card card = findCardById(id);

        // delete object from DB
        cardRepository.delete(card);
    }

    public void deleteAllCards() {
        cardRepository.deleteAll();
    }

    public List<Label> getAllNotEmptyLabels() {
        return cardRepository.findAllLabels();
    }



    public List<Label> getAllLabels() {
        return labelRepository.findAll();
    }

    public Label findLabelById(Long id){
        // check preconditions
        Assert.notNull(id, "Parameter 'id' must not be null");

        return labelRepository.findById(id).orElse(null);
    }

    public Label findLabelByName(String name){
        // check preconditions
        Assert.notNull(name, "Parameter 'name' must not be null");

        // create new label if it doesn't exist
        return labelRepository.findByName(name).orElseGet(() -> labelRepository.save(new Label(name)));
    }

    public Label createLabel(String name) {
        // check preconditions
        Assert.notNull(name, "Parameter 'name' must not be null!");

        // create a new label as plain Java object
        Label label = new Label(name);

        // store entity in DB
        return labelRepository.save(label);
    }

    public void deleteLabelById(Long id) {
        // check preconditions
        // make sure the label to be deleted exists (throw exception if not) and also load the label
        Label label = findLabelById(id);

        // delete object from DB
        labelRepository.delete(label);
    }

    public void deleteLabelByName(String name) {
        // check preconditions
        // make sure the label to be deleted exists (throw exception if not) and also load the label
        Label label = findLabelByName(name);

        // delete object from DB
        labelRepository.delete(label);
    }

    public void deleteAllLabels() {
        labelRepository.deleteAll();
    }
}

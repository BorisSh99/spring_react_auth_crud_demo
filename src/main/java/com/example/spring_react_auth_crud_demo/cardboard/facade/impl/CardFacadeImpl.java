package com.example.spring_react_auth_crud_demo.cardboard.facade.impl;

import com.example.spring_react_auth_crud_demo.cardboard.common.api.datatype.CardData;
import com.example.spring_react_auth_crud_demo.cardboard.dataaccess.api.entity.Label;
import com.example.spring_react_auth_crud_demo.cardboard.common.api.exception.CardNotFoundException;
import com.example.spring_react_auth_crud_demo.cardboard.dataaccess.api.entity.Card;
import com.example.spring_react_auth_crud_demo.cardboard.facade.api.CardFacade;
import com.example.spring_react_auth_crud_demo.cardboard.logic.api.usecase.CardUseCase;
import com.example.spring_react_auth_crud_demo.cardboard.logic.api.usecase.LabelUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/cardboard")
@CrossOrigin
public class CardFacadeImpl implements CardFacade{

    private final CardUseCase cardUseCase;
    private final LabelUseCase labelUseCase;

    @Autowired
    public CardFacadeImpl(CardUseCase cardUseCase, LabelUseCase labelUseCase) {
        this.cardUseCase = cardUseCase;
        this.labelUseCase = labelUseCase;

        //MOCK DATA
        this.labelUseCase.createLabel("Label1");
        this.labelUseCase.createLabel("Label2");
        this.labelUseCase.createLabel("Label3");
        this.labelUseCase.createLabel("Label4");
        this.labelUseCase.createLabel("Label5");
        this.labelUseCase.createLabel("Label6");
        this.labelUseCase.createLabel("Label7");
        this.labelUseCase.createLabel("Label8");
        this.labelUseCase.createLabel("Label9");
        this.labelUseCase.createLabel("Label10");

        this.cardUseCase.createCard("Title1", "Description1", labelUseCase.findLabelByName("Label1"), LocalDate.of(2022, 8, 16));
        this.cardUseCase.createCard("Title2", "Description2", labelUseCase.findLabelByName("Label1"), LocalDate.of(2022, 4, 5));

        this.cardUseCase.createCard("Title3", "Description3", labelUseCase.findLabelByName("Label2"), LocalDate.of(2022, 3, 4));
        this.cardUseCase.createCard("Title4", "Description4", labelUseCase.findLabelByName("Label2"), LocalDate.of(2022, 3, 4));

        this.cardUseCase.createCard("Title5", "Description5", labelUseCase.findLabelByName("Label3"), LocalDate.of(2022, 3, 4));
        this.cardUseCase.createCard("Title6", "Description6", labelUseCase.findLabelByName("Label3"), LocalDate.of(2022, 3, 4));

        this.cardUseCase.createCard("Title7", "Description7", labelUseCase.findLabelByName("Label4"), LocalDate.of(2022, 3, 4));
        this.cardUseCase.createCard("Title8", "Description8", labelUseCase.findLabelByName("Label5"), LocalDate.of(2022, 3, 4));
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
    public Card createCard(@RequestBody CardData cardData) {
        // check preconditions
        Assert.notNull(cardData, "Parameter 'card' must not be null!");

        return cardUseCase.createCard(cardData.getTitle(), cardData.getDescription(), labelUseCase.findLabelByName(cardData.getLabelName()), LocalDate.parse(cardData.getDueDate()));
    }

    @DeleteMapping("/{id}")
    @Override
    public void deleteCardById(@PathVariable("id") Long id) throws CardNotFoundException {
        cardUseCase.deleteCardById(id);
    }



    @GetMapping("/labels")
    @Override
    public List<Label> getLabels() {
        return labelUseCase.getAllLabels();
    }

    @GetMapping("/labels/{name}")
    @Override
    public Label getLabelByName(@PathVariable("name") String name) {
        return labelUseCase.findLabelByName(name);
    }

    @PostMapping("/labels")
    @Override
    public Label createLabel(@RequestBody Label label) {
        // check preconditions
        Assert.notNull(label, "Parameter 'label' must not be null!");

        return labelUseCase.createLabel(label.getName());
    }

    @DeleteMapping("/labels/{name}")
    @Override
    public void deleteLabelByName(@PathVariable("name") String name) {
        labelUseCase.deleteLabelByName(name);
    }
}

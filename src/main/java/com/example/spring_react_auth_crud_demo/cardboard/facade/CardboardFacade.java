package com.example.spring_react_auth_crud_demo.cardboard.facade;

import com.example.spring_react_auth_crud_demo.cardboard.common.datatype.CardData;
import com.example.spring_react_auth_crud_demo.cardboard.common.exception.CardNotFoundException;
import com.example.spring_react_auth_crud_demo.cardboard.dataaccess.entity.Card;
import com.example.spring_react_auth_crud_demo.cardboard.dataaccess.entity.Label;
import com.example.spring_react_auth_crud_demo.cardboard.logic.usecase.CardboardUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/cardboard")
@CrossOrigin
public class CardboardFacade {

    private final CardboardUseCase cardboardUseCase;

    @Autowired
    public CardboardFacade(CardboardUseCase cardboardUseCase) {
        this.cardboardUseCase = cardboardUseCase;

        this.cardboardUseCase.createLabel("Label1");
        this.cardboardUseCase.createLabel("Label2");
        this.cardboardUseCase.createLabel("Label3");
        this.cardboardUseCase.createLabel("Label4");
        this.cardboardUseCase.createLabel("Label5");
        this.cardboardUseCase.createLabel("Label6");

        this.cardboardUseCase.createCard(new CardData("Title1", "Description1", "Label1", "2022-08-16"));
        this.cardboardUseCase.createCard(new CardData("Title2", "Description2", "Label1", "2022-04-05"));

        this.cardboardUseCase.createCard(new CardData("Title3", "Description3", "Label2", "2022-03-04"));
        this.cardboardUseCase.createCard(new CardData("Title4", "Description4", "Label2", "2022-03-04"));

        this.cardboardUseCase.createCard(new CardData("Title5", "Description5", "Label3", "2022-03-04"));
        this.cardboardUseCase.createCard(new CardData("Title6", "Description6", "Label3", "2022-03-04"));

        this.cardboardUseCase.createCard(new CardData("Title7", "Description7", "Label4", "2022-03-04"));
        this.cardboardUseCase.createCard(new CardData("Title8", "Description8", "Label5", "2022-03-04"));
    }

    @GetMapping
    public List<Card> getCards() {
        return cardboardUseCase.getAllCards();
    }

    @GetMapping("/{id}")
    public Card getCardById(@PathVariable("id") Long id) throws CardNotFoundException {
        return cardboardUseCase.findCardById(id);
    }

    @PostMapping
    public Card createCard(@RequestBody CardData cardData) {
        return cardboardUseCase.createCard(cardData);
    }

    @PutMapping("/{id}")
    public Card updateCard(@PathVariable Long id, @RequestBody CardData cardData) throws CardNotFoundException {
        return cardboardUseCase.updateCard(id, cardData);
    }

    @DeleteMapping("/{id}")
    public void deleteCardById(@PathVariable("id") Long id) throws CardNotFoundException {
        cardboardUseCase.deleteCardById(id);
    }



    @GetMapping("/labels")
    public List<Label> getLabels() {
        return cardboardUseCase.getAllLabels();
    }

    @GetMapping("/labels/{name}")
    public Label getLabelByName(@PathVariable("name") String name) {
        return cardboardUseCase.findLabelByName(name);
    }

    @PostMapping("/labels")
    public Label createLabel(@RequestBody Label label) {
        // check preconditions
        Assert.notNull(label, "Parameter 'label' must not be null!");

        return cardboardUseCase.createLabel(label.getName());
    }

    @DeleteMapping("/labels/{name}")
    public void deleteLabelByName(@PathVariable("name") String name) {
        cardboardUseCase.deleteLabelByName(name);
    }
}

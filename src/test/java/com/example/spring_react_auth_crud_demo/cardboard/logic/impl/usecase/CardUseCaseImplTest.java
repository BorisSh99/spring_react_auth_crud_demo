package com.example.spring_react_auth_crud_demo.cardboard.logic.impl.usecase;

import com.example.spring_react_auth_crud_demo.cardboard.dataaccess.api.entity.Label;
import com.example.spring_react_auth_crud_demo.cardboard.common.api.exception.CardNotFoundException;
import com.example.spring_react_auth_crud_demo.cardboard.dataaccess.api.entity.Card;
import com.example.spring_react_auth_crud_demo.cardboard.logic.api.usecase.CardUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SpringBootTest
class CardUseCaseImplTest { //TODO rewrite tests

    @Autowired
    CardUseCase cardUseCase;

    private Card card1;
    private Card card2;
    private Card card3;

    private Label label1;
    private Label label2;

    @BeforeEach
    public void setUp() {
        cardUseCase.deleteAll();

        label1 = new Label("Label1");
        label2 = new Label("Label2");

        card1 = cardUseCase.createCard("Title1", "Description1", label1, LocalDate.of(2022, 8, 16));
        card2 = cardUseCase.createCard("Title2", "Description2", label1, LocalDate.of(2022, 4, 5));
        card3 = cardUseCase.createCard("Title3", "Description3", label2, LocalDate.of(2022, 3, 4));
    }

    @Test
    void testGetAllCards() {
        // [GIVEN]
        // in SetUp

        // [WHEN]
        List<Card> result = cardUseCase.getAllCards();

        // [THEN]
        assertThat(result).extracting(Card::getId).containsExactly(card1.getId(), card2.getId(), card3.getId());
    }

    @Test
    void testGetAllLabels() {
        // [GIVEN]
        // in SetUp

        // [WHEN]
        List<Label> result = cardUseCase.getAllLabels();

        // [THEN]
        assertThat(result).containsExactly(label1, label2);
    }

    @Test
    void testGetCardById_Success() throws CardNotFoundException {
        // [GIVEN]
        // in SetUp

        // [WHEN]
        Card result = cardUseCase.findCardById(card1.getId());

        // [THEN]
        assertThat(result).extracting(Card::getId).isEqualTo(card1.getId());
    }

    @Test
    void testGetCardById_Fail() {
        // [GIVEN]
        // in SetUp

        // [WHEN]
        // [THEN]
        assertThatExceptionOfType(CardNotFoundException.class).isThrownBy(() -> cardUseCase.findCardById(0L));
    }

//    @AfterEach
//    public void tearDown() {
//        cardUseCase.deleteAll();
//    }

}


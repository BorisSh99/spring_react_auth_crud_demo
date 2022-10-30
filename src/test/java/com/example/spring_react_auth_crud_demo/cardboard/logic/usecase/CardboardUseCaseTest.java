package com.example.spring_react_auth_crud_demo.cardboard.logic.usecase;


import com.example.spring_react_auth_crud_demo.cardboard.common.datatype.CardData;
import com.example.spring_react_auth_crud_demo.cardboard.common.exception.CardNotFoundException;
import com.example.spring_react_auth_crud_demo.cardboard.common.exception.LabelNotFoundException;
import com.example.spring_react_auth_crud_demo.cardboard.dataaccess.entity.Card;
import com.example.spring_react_auth_crud_demo.cardboard.dataaccess.entity.Label;
import com.example.spring_react_auth_crud_demo.cardboard.dataaccess.repository.CardRepository;
import com.example.spring_react_auth_crud_demo.cardboard.dataaccess.repository.LabelRepository;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CardboardUseCaseTest {

    @Autowired
    CardboardUseCase cardboardUseCase;

    private Card card1;
    private Card card2;
    private Card card3;

    private Label label1;
    private Label label2;

    @BeforeEach
    public void setUp() {
        cardboardUseCase.deleteAllLabels();

        label1 = new Label("Label1");
        label2 = new Label("Label2");

        card1 = cardboardUseCase.createCard(new CardData("Title1", "Description1", label1.getName(), LocalDate.of(2022, 8, 16)));
        card2 = cardboardUseCase.createCard(new CardData("Title2", "Description2", label1.getName(), LocalDate.of(2022, 4, 5)));
        card3 = cardboardUseCase.createCard(new CardData("Title3", "Description3", label2.getName(), LocalDate.of(2022, 3, 4)));
    }

    @Test
    void testGetAllCards() {
        // [GIVEN]
        // in SetUp

        // [WHEN]
        List<Card> result = cardboardUseCase.getAllCards();

        // [THEN]
        assertThat(result).extracting(Card::getId).containsExactly(card1.getId(), card2.getId(), card3.getId());
    }

    @Test
    void testGetAllLabels() {
        // [GIVEN]
        // in SetUp

        // [WHEN]
        List<Label> result = cardboardUseCase.getAllLabels();

        // [THEN]
        assertThat(result).containsExactly(label1, label2);
    }

    @Test
    void testGetCardById_Success() throws CardNotFoundException {
        // [GIVEN]
        // in SetUp

        // [WHEN]
        Card result = cardboardUseCase.findCardById(card1.getId());

        // [THEN]
        assertThat(result).extracting(Card::getId).isEqualTo(card1.getId());
    }

    @Test
    void testGetCardById_Fail() {
        // [GIVEN]
        // in SetUp

        // [WHEN]
        // [THEN]
        assertThatExceptionOfType(CardNotFoundException.class).isThrownBy(() -> cardboardUseCase.findCardById(0L));
    }


//    @AfterEach
//    public void tearDown() {
//        cardUseCase.deleteAll();
//    }

}

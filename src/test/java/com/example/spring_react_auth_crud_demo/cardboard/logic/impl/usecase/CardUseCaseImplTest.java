package com.example.spring_react_auth_crud_demo.cardboard.logic.impl.usecase;

import com.example.spring_react_auth_crud_demo.SpringReactAuthCrudDemoApplication;
import com.example.spring_react_auth_crud_demo.cardboard.common.api.datatype.Label;
import com.example.spring_react_auth_crud_demo.cardboard.dataaccess.api.entity.Card;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = SpringReactAuthCrudDemoApplication.class)
class CardUseCaseImplTest {

    @Autowired
    CardUseCaseImpl cardUseCase;  // TODO API call instead of Impl

    private Card card1;
    private Card card2;
    private Card card3;

    private Label label1;
    private Label label2;

    @BeforeEach
    public void setUp() {

        label1 = new Label("Label1");
        label2 = new Label("Label2");

        card1 = cardUseCase.createCard("Title1", "Description1", label1, LocalDate.of(2022, 8, 16));
        card2 = cardUseCase.createCard("Title2", "Description2", label1, LocalDate.of(2022, 4, 5));
        card3 = cardUseCase.createCard("Title3", "Description3", label2, LocalDate.of(2022, 3, 4));

    }

    @Test
    void testGetAllCards() {
        // [GIVEN]
        // im SetUp

        // [WHEN]
        List<Card> result = cardUseCase.getAllCards();

        // [THEN]
        assertThat(result).extracting(Card::getId).containsExactly(card1.getId(), card2.getId(), card3.getId());
    }

    @Test
    void testGetAllLabels() {
        // [GIVEN]
        // im SetUp

        // [WHEN]
        List<Label> result = cardUseCase.getAllLabels();

        // [THEN]
        assertThat(result).containsExactly(label1, label2);
    }

    @Test
    void testGetCardById_Success() {
        // [GIVEN]
        // im SetUp

        // [WHEN]
        Card result = cardUseCase.findCardById(card1.getId());

        // [THEN]
        assertThat(result).extracting(Card::getId).isEqualTo(card1.getId());
    }

    @AfterEach
    public void tearDown() {
        cardUseCase.deleteAll();
    }
}


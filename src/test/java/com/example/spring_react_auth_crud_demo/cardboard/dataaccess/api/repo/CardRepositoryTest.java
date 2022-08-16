package com.example.spring_react_auth_crud_demo.cardboard.dataaccess.api.repo;

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
public class CardRepositoryTest {

    @Autowired
    private CardRepository cardRepository;

    private Card card1;
    private Card card2;
    private Card card3;

    private Label label1;
    private Label label2;
    private Label label3;

    @BeforeEach
    public void setUp() {

        label1 = new Label("Label1");
        label2 = new Label("Label2");
        label3 = new Label("Label3");

        card1 = new Card("Title1", "Description1", label1, LocalDate.of(2022, 8, 16));
        card2 = new Card("Title2", "Description2", label1, LocalDate.of(2022, 4, 5));
        card3 = new Card("Title3", "Description3", label2, LocalDate.of(2022, 3, 4));

        card1 = cardRepository.save(card1);
        card2 = cardRepository.save(card2);
        card3 = cardRepository.save(card3);
    }

    @Test
    public void testFindByLabel() {
        // [GIVEN]
        // in SetUp

        // [WHEN]
        List<Card> result1 = cardRepository.findByLabel(label1);
        List<Card> result2 = cardRepository.findByLabel(label2);
        List<Card> result3 = cardRepository.findByLabel(label3);

        // [THEN]

        assertThat(result1).extracting(Card::getId).containsExactly(card1.getId(), card2.getId());
        assertThat(result2).extracting(Card::getId).containsExactly(card3.getId());
        assertThat(result3).isEmpty();

    }

    @Test
    public void testFindAll() {
        // [GIVEN]
        // in SetUp

        // [WHEN]
        List<Card> result = cardRepository.findAll();

        // [THEN]
        assertThat(result).extracting(Card::getId).containsExactly(card1.getId(), card2.getId(), card3.getId());

    }

    @Test
    public void testFindAllLabels() {
        // [GIVEN]
        // in SetUp

        // [WHEN]
        List<Label> result = cardRepository.findAllLabels();

        // [THEN]
        assertThat(result).containsExactly(label1, label2);
    }

    @AfterEach
    public void tearDown() {
        cardRepository.deleteAll();
    }

}


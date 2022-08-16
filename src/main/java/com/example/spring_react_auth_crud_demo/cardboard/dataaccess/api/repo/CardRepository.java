package com.example.spring_react_auth_crud_demo.cardboard.dataaccess.api.repo;

import java.util.List;
import java.util.Optional;

import com.example.spring_react_auth_crud_demo.cardboard.common.api.datatype.Label;
import com.example.spring_react_auth_crud_demo.cardboard.dataaccess.api.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CardRepository extends JpaRepository<Card, Long> {

    Optional<Card> findById(Long id);

    // @Query("SELECT c FROM Card c WHERE c.label = ?1")
    List<Card> findByLabel(Label label);

    List<Card> findAll();

    @Query("SELECT DISTINCT c.label FROM Card c")
    List<Label> findAllLabels();
}


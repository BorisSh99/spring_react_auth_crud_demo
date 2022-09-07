package com.example.spring_react_auth_crud_demo.cardboard.dataaccess.repository;

import com.example.spring_react_auth_crud_demo.cardboard.dataaccess.entity.Card;
import com.example.spring_react_auth_crud_demo.cardboard.dataaccess.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    Optional<Card> findById(Long id);

    // @Query("SELECT c FROM Card c WHERE c.label = ?1")
    List<Card> findByLabel(Label label);

    List<Card> findAll();

    @Query("SELECT DISTINCT c.label FROM Card c")
    List<Label> findAllLabels();
}

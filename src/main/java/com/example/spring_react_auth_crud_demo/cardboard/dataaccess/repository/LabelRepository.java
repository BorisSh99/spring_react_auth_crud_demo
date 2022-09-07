package com.example.spring_react_auth_crud_demo.cardboard.dataaccess.repository;

import com.example.spring_react_auth_crud_demo.cardboard.dataaccess.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long> {

    @Query("SELECT l FROM Label l WHERE l.name = ?1")
    Optional<Label> findByName(String name);
}

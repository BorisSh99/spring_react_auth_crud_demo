package com.example.spring_react_auth_crud_demo.cardboard.logic.api.usecase;

import com.example.spring_react_auth_crud_demo.cardboard.dataaccess.api.entity.Label;

import java.util.List;

public interface LabelUseCase {
    List<Label> getAllLabels();

    Label findLabelById(Long id);

    Label findLabelByName(String name);

    Label createLabel(String name);

    void deleteLabelById(Long id);

    void deleteLabelByName(String name);

    void deleteAll();
}

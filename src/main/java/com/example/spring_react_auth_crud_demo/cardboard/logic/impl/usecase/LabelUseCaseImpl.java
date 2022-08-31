package com.example.spring_react_auth_crud_demo.cardboard.logic.impl.usecase;

import com.example.spring_react_auth_crud_demo.cardboard.dataaccess.api.entity.Label;
import com.example.spring_react_auth_crud_demo.cardboard.dataaccess.api.repo.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class LabelUseCaseImpl implements com.example.spring_react_auth_crud_demo.cardboard.logic.api.usecase.LabelUseCase {

    private final LabelRepository labelRepository;

    @Autowired
    public LabelUseCaseImpl(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    @Override
    public List<Label> getAllLabels() {
        return labelRepository.findAll();
    }

    @Override
    public Label findLabelById(Long id){
        // check preconditions
        Assert.notNull(id, "Parameter 'id' must not be null");

        return labelRepository.findById(id).orElse(null);
    }

    @Override
    public Label findLabelByName(String name){
        // check preconditions
        Assert.notNull(name, "Parameter 'name' must not be null");

        // create new label if it is absent
        return labelRepository.findByName(name).orElseGet(() -> labelRepository.save(new Label(name)));
    }

    @Override
    public Label createLabel(String name) {
        // check preconditions
        Assert.notNull(name, "Parameter 'name' must not be null!");

        // create a new label as plain Java object
        Label label = new Label(name);

        // store entity in DB
        return labelRepository.save(label);
    }

    @Override
    public void deleteLabelById(Long id) {
        // check preconditions
        // make sure the label to be deleted exists (throw exception if not) and also load the label
        Label label = findLabelById(id);

        // delete object from DB
        labelRepository.delete(label);
    }

    @Override
    public void deleteLabelByName(String name) {
        // check preconditions
        // make sure the label to be deleted exists (throw exception if not) and also load the label
        Label label = findLabelByName(name);

        // delete object from DB
        labelRepository.delete(label);
    }

    @Override
    public void deleteAll() {
        labelRepository.deleteAll();
    }

}

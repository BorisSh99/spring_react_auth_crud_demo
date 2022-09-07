package com.example.spring_react_auth_crud_demo.cardboard.dataaccess.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Embeddable  // indicates that the type's attributes can be stored in columns of the owning entity's table
@Entity
public class Label {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "label", cascade = CascadeType.REMOVE) //By removing label card will also be removed
    private List<Card> cardList;

    public Label() {}

    public Label(String name) {
        this.name = name;
        this.cardList = new ArrayList<>();
    }

    public Label(String name, List<Card> cardList) {
        this.name = name;
        this.cardList = cardList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

//    public void addCard(Card card) {
//        cardList.add(card);
//    }
//
//    public void removeCard(Card card) {
//        cardList.remove(card);
//    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;  // self check
//        if (obj == null) return false; // null check
//        if (this.getClass() != obj.getClass())
//            return false;              // type check and cast
//        Label other = (Label) obj;
//        return this.getName().equals(other.getName());
//    }

    @Override
    public String toString() {
        return "Label: " + name;
    }

}

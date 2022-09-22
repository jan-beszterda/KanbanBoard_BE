package com.grupp3.ooad_projekt_backend.models;

import javax.persistence.*;

@Entity
@Table(	name = "cards",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "cardname")
        })
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardName;

    public Card(String cardName) {
        this.cardName = cardName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
}

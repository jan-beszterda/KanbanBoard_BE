package com.grupp3.ooad_projekt_backend.dao;

import com.grupp3.ooad_projekt_backend.models.Card;
import com.grupp3.ooad_projekt_backend.repository.CardRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CardDAO {

    private CardRepository repository;

    public CardDAO(CardRepository repository) {
        this.repository = repository;
    }

    public Optional<Card> findCardById(Long id) {
        return repository.findById(id);
    }

    public Card saveCard(Card card) {
        return repository.save(card);
    }

    public Iterable<Card> findAllCards() {
        return repository.findAll();
    }

}

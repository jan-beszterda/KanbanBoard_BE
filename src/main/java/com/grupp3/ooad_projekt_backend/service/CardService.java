package com.grupp3.ooad_projekt_backend.service;

import com.grupp3.ooad_projekt_backend.dao.CardDAO;
import com.grupp3.ooad_projekt_backend.models.Card;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    private CardDAO cardDAO;

    public CardService(CardDAO cardDAO) {
        this.cardDAO = cardDAO;
    }

    public List<Card> getAllCards() {
        return (List<Card>) cardDAO.findAllCards();
    }

    public Card getCardById(Long id) {
        return cardDAO.findCardById(id).orElse(null);
    }

    public Card addCard(Card card) {
        return cardDAO.saveCard(card);
    }

    public void removeCard(Long id) {
        cardDAO.deleteCardById(id);
    }

}

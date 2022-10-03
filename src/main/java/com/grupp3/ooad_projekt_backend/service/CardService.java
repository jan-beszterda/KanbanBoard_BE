package com.grupp3.ooad_projekt_backend.service;

import com.grupp3.ooad_projekt_backend.dao.CardDAO;
import com.grupp3.ooad_projekt_backend.dao.ColumnDAO;
import com.grupp3.ooad_projekt_backend.dao.UserDAO;
import com.grupp3.ooad_projekt_backend.models.Card;
import com.grupp3.ooad_projekt_backend.models.Column;
import com.grupp3.ooad_projekt_backend.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    private CardDAO cardDAO;
    private UserDAO userDAO;
    private ColumnDAO columnDAO;

    public CardService(CardDAO cardDAO, UserDAO userDAO, ColumnDAO columnDAO) {
        this.cardDAO = cardDAO;
        this.userDAO = userDAO;
        this.columnDAO = columnDAO;
    }

    public List<Card> getAllCards() {
        return (List<Card>) cardDAO.findAllCards();
    }

    public Card getCardById(Long id) {
        return cardDAO.findCardById(id).orElse(null);
    }

    public Card addCard(Long userId, Long columnId, Card card) {
        Optional<User> maybeUser = userDAO.getUserById(userId);
        if (maybeUser.isEmpty()) {
            return null;
        }
        User user = maybeUser.get();
        card.setAuthor(user);
        Optional<Column> maybeColumn = columnDAO.findColumnById(columnId);
        if(maybeColumn.isEmpty()) {
            return null;
        }
        Column column = maybeColumn.get();
        if (null == column.getCardList()) {
            column.setCardList(new ArrayList<>());
        }
        column.getCardList().add(card);
        //columnDAO.saveColumn(column);
        return cardDAO.saveCard(card);
    }

    public void removeCardById(Long id) {
        cardDAO.removeCardById(id);
    }
}

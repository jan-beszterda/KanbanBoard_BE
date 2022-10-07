package com.grupp3.ooad_projekt_backend.service;

import com.grupp3.ooad_projekt_backend.dao.BoardDAO;
import com.grupp3.ooad_projekt_backend.dao.CardDAO;
import com.grupp3.ooad_projekt_backend.dao.ColumnDAO;
import com.grupp3.ooad_projekt_backend.dao.UserDAO;
import com.grupp3.ooad_projekt_backend.models.Board;
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
    private BoardDAO boardDAO;

    public CardService(CardDAO cardDAO, UserDAO userDAO, ColumnDAO columnDAO, BoardDAO boardDAO) {
        this.cardDAO = cardDAO;
        this.userDAO = userDAO;
        this.columnDAO = columnDAO;
        this.boardDAO = boardDAO;
    }

    public List<Card> getAllCards() {
        return (List<Card>) cardDAO.findAllCards();
    }

    public Card getCardById(Long id) {
        return cardDAO.findCardById(id).orElse(null);
    }

    public Card addCard(Long userId, Long boardId, Long columnId, Card card) {
        Optional<User> maybeUser = userDAO.getUserById(userId);
        if (maybeUser.isEmpty()) {
            return null;
        }
        User user = maybeUser.get();
        card.setAuthor(user);

        Optional<Board> maybeBoard = boardDAO.findBoardById(boardId);
        if (maybeBoard.isEmpty()) {
            return null;
        }
        Board board = maybeBoard.get();

        Optional<Column> maybeColumn = columnDAO.findColumnById(columnId);
        if(maybeColumn.isEmpty()) {
            return null;
        }
        Column column = maybeColumn.get();
        if (null == column.getCardList()) {
            column.setCardList(new ArrayList<>());
        }

        int index = board.getColumnList().indexOf(column);

        column.getCardList().add(card);
        board.getColumnList().remove(index);
        board.getColumnList().add(index, column);
        boardDAO.saveBoard(board);
        return card;
    }

    public void removeCardById(Long id) {
        cardDAO.removeCardById(id);
    }
}

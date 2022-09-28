package com.grupp3.ooad_projekt_backend.service;

import com.grupp3.ooad_projekt_backend.dao.CardDAO;
import com.grupp3.ooad_projekt_backend.dao.ColumnDAO;
import com.grupp3.ooad_projekt_backend.models.Card;
import com.grupp3.ooad_projekt_backend.models.Board;
import com.grupp3.ooad_projekt_backend.models.Column;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColumnService {

    final private ColumnDAO columnDAO;
    final private CardDAO cardDAO;

    public ColumnService(ColumnDAO columnDAO, CardDAO cardDAO) {
        this.columnDAO = columnDAO;
        this.cardDAO = cardDAO;
    }

    public List<Column> getAllColumns() {
        return (List<Column>) columnDAO.findAllColumns();
    }

    public Column getColumnById(Long id) {
        return columnDAO.findColumnById(id).orElse(null);
    }

    public Column addColumn(Column column) {
        return columnDAO.saveColumn(column);
    }

    public void moveCard(Long cardId, Long columnId1, Long columnId2) {
        Optional<Column> maybeColumnFrom = columnDAO.findColumnById(columnId1);
        if (maybeColumnFrom.isEmpty()) {
            return;
        }
        Column columnFrom = maybeColumnFrom.get();

        Optional<Column> maybeColumnTo = columnDAO.findColumnById(columnId2);
        if (maybeColumnTo.isEmpty()) {
            return;
        }
        Column columnTo = maybeColumnTo.get();

        Optional<Card> maybeCard = cardDAO.findCardById(cardId);
        if (maybeCard.isEmpty()) {
            return;
        }
        Card cardToMove = maybeCard.get();

        columnFrom.getCardList().remove(cardToMove);
        columnTo.getCardList().add(cardToMove);

        columnDAO.saveColumn(columnFrom);
        columnDAO.saveColumn(columnTo);

    }
    
    public void removeColumnById(Long id) {
        columnDAO.removeColumnById(id);
    }
}


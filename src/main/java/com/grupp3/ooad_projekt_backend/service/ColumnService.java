package com.grupp3.ooad_projekt_backend.service;

import com.grupp3.ooad_projekt_backend.dao.CardDAO;
import com.grupp3.ooad_projekt_backend.dao.ColumnDAO;
import com.grupp3.ooad_projekt_backend.models.Column;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColumnService {

    private ColumnDAO columnDAO;
    private CardDAO cardDAO;

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


}

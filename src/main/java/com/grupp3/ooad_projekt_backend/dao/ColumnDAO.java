package com.grupp3.ooad_projekt_backend.dao;

import com.grupp3.ooad_projekt_backend.models.Column;
import com.grupp3.ooad_projekt_backend.repository.ColumnRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ColumnDAO {

    private ColumnRepository columnRepository;

    public ColumnDAO(ColumnRepository columnRepository) {
        this.columnRepository = columnRepository;
    }

    public Optional<Column> findColumnById(Long id) {
        return columnRepository.findById(id);
    }

    public Column saveColumn(Column column) {
        return columnRepository.save(column);
    }

    public Object findAllColumns() {return columnRepository.findAll();}

}


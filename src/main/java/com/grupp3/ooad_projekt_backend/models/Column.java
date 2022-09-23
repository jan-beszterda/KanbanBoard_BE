package com.grupp3.ooad_projekt_backend.models;

import javax.persistence.*;

@Entity
@Table(	name = "columns",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "columnname")
        })
public class Column {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String columnName;


    public Column() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String cardName) {
        this.columnName = cardName;
    }
}

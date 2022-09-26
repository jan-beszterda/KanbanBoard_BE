package com.grupp3.ooad_projekt_backend.models;

import javax.persistence.*;

@Entity
@Table(name = "columns")
public class Column {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long columnId;

    @ManyToOne
    @JoinColumn(name = "id")
    private Board board;

    public Column() {
    }

    public long getColumnId() {
        return columnId;
    }

    public void setColumnId(long columnId) {
        this.columnId = columnId;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
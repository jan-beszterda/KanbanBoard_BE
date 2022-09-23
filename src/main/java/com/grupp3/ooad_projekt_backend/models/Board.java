package com.grupp3.ooad_projekt_backend.models;

import javax.persistence.*;

@Entity
@Table(	name = "boards",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "boardname")
        })
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String boardName;

    public Board() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }
}

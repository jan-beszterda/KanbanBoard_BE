package com.grupp3.ooad_projekt_backend.service;

import com.grupp3.ooad_projekt_backend.dao.BoardDAO;


public class BoardService {
    BoardDAO boardDAO;
    public BoardService(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }
}






package com.grupp3.ooad_projekt_backend.service;

import com.grupp3.ooad_projekt_backend.dao.BoardDAO;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    BoardDAO boardDAO;
    public BoardService(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }
}






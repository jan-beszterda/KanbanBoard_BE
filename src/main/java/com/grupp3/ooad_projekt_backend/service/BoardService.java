package com.grupp3.ooad_projekt_backend.service;

import com.grupp3.ooad_projekt_backend.dao.BoardDAO;
import com.grupp3.ooad_projekt_backend.models.Board;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private BoardDAO boardDAO;
    public BoardService(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    public List<Board> getAllBoards() {
        return boardDAO.findAllBoards();
    }

    public Board getBoardById(Long id) {
        return boardDAO.findBoardById(id).orElse(null);
    }

    public Board addBoard(Board board) {
        return boardDAO.saveBoard(board);
    }

    public void removeBoardById(Long id) {
        boardDAO.removeBoardById(id);
    }
}






package com.grupp3.ooad_projekt_backend.dao;

import com.grupp3.ooad_projekt_backend.models.Board;
import com.grupp3.ooad_projekt_backend.models.Column;
import com.grupp3.ooad_projekt_backend.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class BoardDAO {

    private BoardRepository boardRepository;

    public List<Board> findAllBoards() {
        return boardRepository.findAll();
    }

    public Optional<Board> findBoardById(Long id) {
        return boardRepository.findById(id);
    }

    public Board saveBoard(Board board) {
        return boardRepository.save(board);
    }

    public void removeBoardById(Long id) {
        boardRepository.deleteById(id);
    }

}


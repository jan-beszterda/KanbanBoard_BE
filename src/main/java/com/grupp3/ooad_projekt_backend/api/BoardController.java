package com.grupp3.ooad_projekt_backend.api;

import com.grupp3.ooad_projekt_backend.models.Board;
import com.grupp3.ooad_projekt_backend.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
@AllArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public List<Board> getAllBoards() {
        return boardService.getAllBoards();
    }

    @GetMapping("/{id}")
    public Board getBoardById(@PathVariable("id") Long id) {
        return boardService.getBoardById(id);
    }

    @PostMapping
    public Board createBoard(@RequestBody Board board) {
        return boardService.addBoard(board);
    }

    @DeleteMapping("/{id}")
    public void deleteBoardById(@PathVariable("id") Long id) {
        boardService.removeBoardById(id);
    }
}

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

    @GetMapping("/move/{board_id}/{column_id}/{new_index}")
    public Board moveColumn(@PathVariable("board_id") Long boardId, @PathVariable("column_id") Long columnId, @PathVariable("new_index") int index) {
        return boardService.moveColumn(boardId, columnId, index);
    }

    @PostMapping("/{teamId}/create")
    public Board createBoard(@PathVariable("teamId") Long teamId, @RequestBody Board board) {
        return boardService.addBoard(teamId, board);
    }

    @DeleteMapping("/{id}")
    public void deleteBoardById(@PathVariable("id") Long id) {
        boardService.removeBoardById(id);
    }

    @GetMapping("/team")
    public List<Board> getBoardsByTeamId(@RequestParam(value = "team") String id) {
        return boardService.getBoardByTeamId(Long.parseLong(id));
    }
}

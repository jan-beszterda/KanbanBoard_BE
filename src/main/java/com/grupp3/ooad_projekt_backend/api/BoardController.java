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

    @PutMapping("/{board_id}/move_column/{column_id}")
    public Board moveColumn(@PathVariable("board_id") Long boardId, @PathVariable("column_id") Long columnId, @RequestParam("to_position") Integer index) {
        return boardService.moveColumn(boardId, columnId, index);
    }

    @PostMapping("/create")
    public Board createBoard(@RequestParam("team_id") Long teamId, @RequestBody Board board) {
        return boardService.addBoard(teamId, board);
    }

    @DeleteMapping("/{id}")
    public void deleteBoardById(@PathVariable("id") Long id) {
        boardService.removeBoardById(id);
    }

    @GetMapping("/forTeam")
    public List<Board> getBoardsByTeamId(@RequestParam(value = "team_id") Long id) {
        return boardService.getBoardByTeamId(id);
    }
}

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

    @GetMapping("/{board_id}")
    public Board getBoardById(@PathVariable("board_id") Long board_id) {
        return boardService.getBoardById(board_id);
    }

    @PutMapping("/{board_id}/move_column/{column_id}")
    public Board moveColumn(@PathVariable("board_id") Long boardId, @PathVariable("column_id") Long columnId, @RequestParam("to_position") Integer index) {
        return boardService.moveColumn(boardId, columnId, index);
    }

    @PostMapping("/create")
    public Board createBoard(@RequestParam("owner_team") Long teamId, @RequestBody Board board) {
        return boardService.addBoard(teamId, board);
    }

    @PutMapping("/{board_id}/update")
    public Board updateBoard(@PathVariable("board_id") Long boardId, @RequestBody Board board) {
        return boardService.updateBoard(boardId, board);
    }



    @DeleteMapping("/{board_id}")
    public void deleteBoardById(@PathVariable("board_id") Long boardId) {
        boardService.removeBoardById(boardId);
    }

    @GetMapping("/forTeam")
    public List<Board> getBoardsByTeamId(@RequestParam(value = "team_id") Long id) {
        return boardService.getBoardByTeamId(id);
    }

    @PutMapping("/{board_id}/remove_column")
    public Board removeColumnFromBoard(@PathVariable("board_id") Long boardId, @RequestParam("column_id") Long columnId) {
        return boardService.removeColumnFromBoard(boardId, columnId);
    }
}

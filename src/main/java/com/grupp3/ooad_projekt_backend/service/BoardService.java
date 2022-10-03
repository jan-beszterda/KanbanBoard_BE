package com.grupp3.ooad_projekt_backend.service;

import com.grupp3.ooad_projekt_backend.dao.BoardDAO;
import com.grupp3.ooad_projekt_backend.dao.TeamDAO;
import com.grupp3.ooad_projekt_backend.models.Board;
import com.grupp3.ooad_projekt_backend.models.Column;
import com.grupp3.ooad_projekt_backend.models.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    final private BoardDAO boardDAO;
    final private TeamDAO teamDAO;
    public BoardService(BoardDAO boardDAO, TeamDAO teamDAO) {
        this.boardDAO = boardDAO;
        this.teamDAO = teamDAO;
    }

    public List<Board> getAllBoards() {
        return boardDAO.findAllBoards();
    }

    public Board getBoardById(Long id) {
        return boardDAO.findBoardById(id).orElse(null);
    }

    public Board addBoard(Long teamId, Board board) {
        board = boardDAO.saveBoard(board);
        Optional<Team> maybeTeam = teamDAO.getTeamById(teamId);
        if (maybeTeam.isEmpty()) {
            return null;
        }
        Team team = maybeTeam.get();
        List<Board> teamBoards = team.getBoards();
        if (teamBoards == null) {
            teamBoards = new ArrayList<>();
        }
        teamBoards.add(board);
        teamDAO.addTeam(team);
        return board;
    }

    public void removeBoardById(Long id) {
        boardDAO.removeBoardById(id);
    }

    public List<Board> getBoardByTeamId(Long id) {
        Optional<Team> team = teamDAO.getTeamById(id);
        if (team.isEmpty()) {
            return null;
        }
        return team.get().getBoards();
    }

    public Board moveColumn(Long boardId, Long columnId, int index) {
        Optional<Board> maybeBoard = boardDAO.findBoardById(boardId);
        if(maybeBoard.isEmpty()) {
            return null;
        }
        Board board = maybeBoard.get();
        List<Column> columnList = board.getColumnList();
        Column column = columnList
                .stream()
                .filter(p -> p.getColumnId() == columnId)
                .toList()
                .get(0);
        if (column == null){
            return null;
        }
        columnList.remove(column);
        columnList.add(index, column);
        board.setColumnList(columnList);
        return boardDAO.saveBoard(board);
    }
}






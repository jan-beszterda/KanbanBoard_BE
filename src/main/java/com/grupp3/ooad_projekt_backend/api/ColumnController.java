package com.grupp3.ooad_projekt_backend.api;

import com.grupp3.ooad_projekt_backend.models.Column;
import com.grupp3.ooad_projekt_backend.service.BoardService;
import com.grupp3.ooad_projekt_backend.service.ColumnService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/column")
public class ColumnController {

    private ColumnService columnService;
    private BoardService boardService;

    public ColumnController(ColumnService columnService) {
        this.columnService = columnService;
    }

    @GetMapping()
    public List<Column> getAllColumns() {
        return columnService.getAllColumns();
    }

    @GetMapping("/{id}")
    public Column getColumnById(@PathVariable("id") Long id) {
        return columnService.getColumnById(id);
    }

    @PostMapping("/create")
    public Column addColumn(@RequestParam("board_id") Long boardId, @RequestBody Column column) {
        return columnService.addColumn(boardId, column);
    }

    @DeleteMapping("/{id}")
    public void deleteColumnById(@PathVariable("id") Long id) {
        columnService.removeColumnById(id);
    }
}

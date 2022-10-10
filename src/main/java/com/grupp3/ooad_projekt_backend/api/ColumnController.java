package com.grupp3.ooad_projekt_backend.api;

import com.grupp3.ooad_projekt_backend.models.Column;
import com.grupp3.ooad_projekt_backend.service.ColumnService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/column")
public class ColumnController {

    private ColumnService columnService;

    public ColumnController(ColumnService columnService) {
        this.columnService = columnService;
    }

    @GetMapping()
    public List<Column> getAllColumns() {
        return columnService.getAllColumns();
    }

    @GetMapping("/{column_id}")
    public Column getColumnById(@PathVariable("column_id") Long id) {
        return columnService.getColumnById(id);
    }

    @PostMapping("/create")
    public Column addColumn(@RequestParam("board_id") Long boardId, @RequestBody Column column) {
        return columnService.addColumn(boardId, column);
    }

    @DeleteMapping("/{column_id}")
    public void deleteColumnById(@PathVariable("column_id") Long id) {
        columnService.removeColumnById(id);
    }


    @PutMapping("{column_id}/edit")
    public String editColumnTitle(@PathVariable("column_id") Long columnId, @RequestParam String columnTitle) {
        return columnService.editColumnTitle(columnId, columnTitle);
    }
}
package com.grupp3.ooad_projekt_backend.api;

import com.grupp3.ooad_projekt_backend.models.Comment;
import com.grupp3.ooad_projekt_backend.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping()
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable("id") Long id) {
        return commentService.getCommentById(id);
    }

    @PostMapping("/create")
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

}

package com.grupp3.ooad_projekt_backend.dao;

import com.grupp3.ooad_projekt_backend.models.Comment;
import com.grupp3.ooad_projekt_backend.repository.CommentRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CommentDAO {

    private CommentRepository repository;

    public CommentDAO(CommentRepository repository) {
        this.repository = repository;
    }

    public Iterable<Comment> findAllComments() {
        return repository.findAll();
    }

    public Optional<Comment> findCommentById(Long id) {
        return repository.findById(id);
    }

    public Comment saveComment(Comment comment) {
        return repository.save(comment);
    }
}

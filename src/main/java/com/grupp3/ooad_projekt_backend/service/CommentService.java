package com.grupp3.ooad_projekt_backend.service;

import com.grupp3.ooad_projekt_backend.dao.CommentDAO;
import com.grupp3.ooad_projekt_backend.models.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private CommentDAO commentDAO;

    public CommentService(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    public List<Comment> getAllComments() {
        return (List<Comment>) commentDAO.findAllComments();
    }

    public Comment getCommentById(Long id) {
        return commentDAO.findCommentById(id).orElse(null);
    }

    public Comment addComment(Comment comment) {
        return commentDAO.saveComment(comment);
    }
}

package com.grupp3.ooad_projekt_backend.service;

import com.grupp3.ooad_projekt_backend.dao.CardDAO;
import com.grupp3.ooad_projekt_backend.dao.CommentDAO;
import com.grupp3.ooad_projekt_backend.dao.UserDAO;
import com.grupp3.ooad_projekt_backend.models.Card;
import com.grupp3.ooad_projekt_backend.models.Comment;
import com.grupp3.ooad_projekt_backend.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private CommentDAO commentDAO;
    private UserDAO userDAO;
    private CardDAO cardDAO;

    public CommentService(CommentDAO commentDAO, UserDAO userDAO, CardDAO cardDAO) {
        this.commentDAO = commentDAO;
        this.userDAO = userDAO;
        this.cardDAO = cardDAO;
    }

    public List<Comment> getAllComments() {
        return (List<Comment>) commentDAO.findAllComments();
    }

    public Comment getCommentById(Long id) {
        return commentDAO.findCommentById(id).orElse(null);
    }

    public Comment addComment(Long userId, Long cardId, Comment comment) {
        Optional<User> maybeUser = userDAO.getUserById(userId);
        if (maybeUser.isEmpty()) {
            return null;
        }
        User user = maybeUser.get();
        comment.setUser(user);
        Optional<Card> maybeCard = cardDAO.findCardById(cardId);
        if(maybeCard.isEmpty()) {
            return null;
        }
        Card card = maybeCard.get();
        if (null == card.getComments()) {
            card.setComments(new ArrayList<>());
        }
        card.getComments().add(comment);
        return commentDAO.saveComment(comment);
    }
}

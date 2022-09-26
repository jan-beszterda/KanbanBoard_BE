package com.grupp3.ooad_projekt_backend.service;

import com.grupp3.ooad_projekt_backend.dao.UserDAO;
import com.grupp3.ooad_projekt_backend.models.Card;
import com.grupp3.ooad_projekt_backend.models.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    UserDAO userDAO;
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Optional<User> getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    public User getLoginUser(User maybeUser){
        return userDAO.getLoginUser(maybeUser);
    }
}






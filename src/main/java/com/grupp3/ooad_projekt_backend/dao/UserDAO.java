package com.grupp3.ooad_projekt_backend.dao;

import com.grupp3.ooad_projekt_backend.models.Card;
import com.grupp3.ooad_projekt_backend.models.User;
import com.grupp3.ooad_projekt_backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class UserDAO {
    UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User getLoginUser(User maybeUser) {
        List<User> users = userRepository.findAll();
        for (User u : users) {
            if (u.getEmail().equals(maybeUser.getEmail()) && u.getPassword().equals(maybeUser.getPassword())) {
                return u;
            }
        }
        return null;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public void removeUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> getUserByEmail(String userEmail) {
        return userRepository.findAll().stream().filter(user -> user.getEmail().equals(userEmail)).toList();
    }
}


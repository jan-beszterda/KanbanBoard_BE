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
        List<User>  storedUsers = userRepository.findAll().stream()
                .filter(p->p.getUserName().equals(maybeUser.getUserName()))
                .filter(p -> p.getPassword().equals(maybeUser.getPassword()))
                .toList();
        if(storedUsers.isEmpty()){
            return null;
        }
        return storedUsers.get(0);
            }

    public User addUser(User user) {
        return userRepository.save(user);
    }
}


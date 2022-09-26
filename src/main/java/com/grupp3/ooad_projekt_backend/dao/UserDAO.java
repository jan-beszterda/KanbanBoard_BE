package com.grupp3.ooad_projekt_backend.dao;

import com.grupp3.ooad_projekt_backend.models.Card;
import com.grupp3.ooad_projekt_backend.models.User;
import com.grupp3.ooad_projekt_backend.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
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

    public Optional<User> getLoginUser(User maybeUser) {
       // Optional<User>  storedUser = userRepository.findByUsername(maybeUser.getUserName());
        //if(storedUser.isPresent()){
          //  if(storedUser.get().getPassword().equals(maybeUser.getPassword())){
            //    return storedUser;
            //}
        //}
        return null;
    }
}


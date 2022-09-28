package com.grupp3.ooad_projekt_backend.service;

import com.grupp3.ooad_projekt_backend.dao.UserDAO;
import com.grupp3.ooad_projekt_backend.dao.TeamDAO;
import com.grupp3.ooad_projekt_backend.models.Team;
import com.grupp3.ooad_projekt_backend.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    UserDAO userDAO;
    TeamDAO teamDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Optional<User> getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    public User getLoginUser(User maybeUser){
        return userDAO.getLoginUser(maybeUser);
    }

    public User addUser(User user) {
        return userDAO.addUser(user);
    }

    public Team acceptInvite(Long userId, Long teamId) {
        Optional<User> maybeUser = userDAO.getUserById(userId);
        Optional<Team> maybeTeam = teamDAO.getTeamById(teamId);
        if (maybeUser.isEmpty() || maybeTeam.isEmpty()) {
            return null;
        }
        if (maybeUser.get().getInvitations().contains(maybeTeam.get())) {
            Team team = maybeTeam.get();
            User user = maybeUser.get();
            return teamDAO.addMember(team, user);
        }
        return null;
    }

    public List<User> getUsersByName(String userName) {
        return userDAO.getAllUsers().stream().filter(p -> p.getUserName().equals(userName)).toList();
    }

    public List<User> getUsersByEmail(String userEmail) {
        return userDAO.getAllUsers().stream().filter(p -> p.getEmail().equals(userEmail)).toList();
    }
}






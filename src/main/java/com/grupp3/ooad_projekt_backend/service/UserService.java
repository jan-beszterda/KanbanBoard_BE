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

    public UserService(UserDAO userDAO, TeamDAO teamDAO) {
        this.userDAO = userDAO;
        this.teamDAO = teamDAO;
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
        User user = maybeUser.get();
        Team team = maybeTeam.get();
        if (user.getInvitations().contains(team)) {
            team.getInvited().remove(user);
            return teamDAO.addMember(team, user);
        }
        return null;
    }



    public User getUserByEmail(String userEmail) {
        List<User> users = userDAO.getAllUsers()
                .stream()
                .filter(p -> p.getEmail().equals(userEmail))
                .toList();
        if(users.size() == 0) return null;
        return users.get(0);
    }

    public void removeUser(Long id) {
        userDAO.removeUser(id);
    }

    public Team denyInvite(Long userId, Long teamId) {
        Optional<User> maybeUser = userDAO.getUserById(userId);
        Optional<Team> maybeTeam = teamDAO.getTeamById(teamId);
        if (maybeUser.isEmpty() || maybeTeam.isEmpty()) {
            return null;
        }
        User user = maybeUser.get();
        Team team = maybeTeam.get();
        if (user.getInvitations().contains(team)) {
            team.getInvited().remove(user);
            teamDAO.saveTeam(team);
            //user.getInvitations().remove(team);
            //userDAO.save(user);
        }
        return null;
    }
    public void setUserName(Long id, String newName) {

        Optional<User> maybeUser = userDAO.getUserById(id);
        if (maybeUser.isPresent()) {
            User user = maybeUser.get();
            if (newName.contains(" ")) {
                String[] name = newName.split(" ", 2);
                user.setFirstName(name[0]);
                user.setLastName(name[1]);
                userDAO.save(user);

            } else {
                user.setFirstName(newName);
                user.setLastName("");
                userDAO.save(user);
            }


        }
    }
}






package com.grupp3.ooad_projekt_backend.service;

import com.grupp3.ooad_projekt_backend.dao.TeamDAO;
import com.grupp3.ooad_projekt_backend.dao.UserDAO;
import com.grupp3.ooad_projekt_backend.models.Team;
import com.grupp3.ooad_projekt_backend.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    private TeamDAO teamDAO;
    private UserDAO userDAO;

    public TeamService(TeamDAO teamDAO, UserDAO userDAO) {
        this.teamDAO = teamDAO;
        this.userDAO = userDAO;
    }

    public Team getTeamById(Long teamId) {
        Optional<Team> maybeTeam = teamDAO.getTeamById(teamId);
        if(maybeTeam.isEmpty()){
            return null;
        }
        return maybeTeam.get();
    }

    public Team addTeam(Long userId, Team team) {
        User user = userDAO.getUserById(userId).orElse(null);
        if (user == null) {
            return null;
        }
        if (null == team.getTeamMembers()) {
            team.setTeamMembers(new ArrayList<>());
        }
        team.getTeamMembers().add(user);
        team = teamDAO.addTeam(team);
        return team;
    }

    public List<Team> getTeamsByMemberId(Long userId) {
        return teamDAO.findAllTeams().stream()
                .filter(team -> team.getTeamMembers().stream()
                        .anyMatch(user -> userId.equals(user.getUserId())))
                .toList();
    }

    public List<Team> getTeamsByName(String teamName) {
        return teamDAO.findAllTeams()
                .stream()
                .filter(p -> p.getTeamName().equals(teamName))
                .toList();
    }

    public String inviteUserToTeam(Long teamId, Long userId) {
        Optional<Team> maybeTeam = teamDAO.getTeamById(teamId);
        if (maybeTeam.isEmpty()){
            return "Team could not be found.";
        }

        Optional<User> maybeUser = userDAO.getUserById(userId);
        if (maybeUser.isEmpty()){
            return "User could not be found.";
        }

        User user = maybeUser.get();
        Team team = maybeTeam.get();

        if (null == team.getInvited()) {
            team.setInvited(new ArrayList<>());
        }
        team.getInvited().add(user);
        teamDAO.addTeam(team);

        return "User " + user.getUserName() + " is invited to team " + team.getTeamName();
    }
}






package com.grupp3.ooad_projekt_backend.service;

import com.grupp3.ooad_projekt_backend.dao.TeamDAO;
import com.grupp3.ooad_projekt_backend.dao.UserDAO;
import com.grupp3.ooad_projekt_backend.models.Board;
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

    public Team addTeam(Long id, Team team) {
        User user = userDAO.getUserById(id).orElse(null);
        if (user == null) {
            return null;
        }
        //team.getTeamMembers().add(user);
        team.setTeamMembers(new ArrayList<>(List.of(user)));
        //user.getTeams().add(team);
        //user.setTeams(new ArrayList<>(List.of(team)));
        team = teamDAO.addTeam(team);
        //userDAO.addUser(user);
        return team;
    }

    public List<Team> getTeamsByMemberId(Long userId) {
        return teamDAO.findAllTeams().stream()
                .filter(team -> team.getTeamMembers().stream()
                        .anyMatch(user -> userId.equals(user.getId())))
                .toList();
    }
    
    public Team newTeam(Team newTeam) {
        return newTeam;
    }

    public List<Team> getTeamsByName(String teamName) {
        return teamDAO.getAllTeams().stream().filter(p -> p.getTeamName().equals(teamName)).toList();
    }
}






package com.grupp3.ooad_projekt_backend.service;

import com.grupp3.ooad_projekt_backend.dao.TeamDAO;
import com.grupp3.ooad_projekt_backend.models.Team;
import com.grupp3.ooad_projekt_backend.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    TeamDAO teamDAO;
    public TeamService(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    public Team getTeamById(Long teamId) {
        Optional<Team> maybeTeam = teamDAO.getTeamById(teamId);
        if(maybeTeam.isEmpty()){
            return null;
        }
        return maybeTeam.get();
    }

    public Team newTeam(Team newTeam) {
        return newTeam;
    }

    public List<Team> getTeamsByName(String teamName) {
        return teamDAO.getAllTeams().stream().filter(p -> p.getTeamName().equals(teamName)).toList();
    }


}






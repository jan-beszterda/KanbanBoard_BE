package com.grupp3.ooad_projekt_backend.service;

import com.grupp3.ooad_projekt_backend.dao.TeamDAO;
import com.grupp3.ooad_projekt_backend.models.Team;
import org.springframework.stereotype.Service;

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

}






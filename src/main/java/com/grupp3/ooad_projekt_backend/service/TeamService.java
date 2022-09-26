package com.grupp3.ooad_projekt_backend.service;

import com.grupp3.ooad_projekt_backend.dao.TeamDAO;
import com.grupp3.ooad_projekt_backend.models.Team;
import com.grupp3.ooad_projekt_backend.models.User;

import java.util.Optional;

public class TeamService {
    TeamDAO teamDAO;
    public TeamService(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    public Optional<Team> getTeamById(Long id) {


            return teamDAO.getTeamById(id);

    }
}






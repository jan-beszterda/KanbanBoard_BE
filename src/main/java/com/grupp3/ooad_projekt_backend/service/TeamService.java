package com.grupp3.ooad_projekt_backend.service;

import com.grupp3.ooad_projekt_backend.dao.TeamDAO;

public class TeamService {
    TeamDAO teamDAO;
    public TeamService(TeamDAO userDAO) {
        this.teamDAO = teamDAO;
    }
}






package com.grupp3.ooad_projekt_backend.service;

import com.grupp3.ooad_projekt_backend.dao.TeamDAO;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    TeamDAO teamDAO;
    public TeamService(TeamDAO userDAO) {
        this.teamDAO = teamDAO;
    }
}






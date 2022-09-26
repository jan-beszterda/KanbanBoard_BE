package com.grupp3.ooad_projekt_backend.dao;

import com.grupp3.ooad_projekt_backend.models.Team;

import com.grupp3.ooad_projekt_backend.models.User;
import com.grupp3.ooad_projekt_backend.repository.TeamRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TeamDAO {
    private TeamRepository teamRepository;

    public TeamDAO(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Optional<Team> getTeamById(Long id) {
        return teamRepository.findById(id);
    }
}


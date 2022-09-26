package com.grupp3.ooad_projekt_backend.models;

import javax.persistence.*;

@Entity
@Table(	name = "teams",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "teamname")
        })
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamName;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}

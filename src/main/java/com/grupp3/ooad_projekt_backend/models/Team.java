package com.grupp3.ooad_projekt_backend.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamId;
    private String teamName;
    private String teamDescription;
    @ManyToMany
    @JoinTable(
            name = "team_members",
            joinColumns = @JoinColumn(name = "teamId"),
            inverseJoinColumns = @JoinColumn(name = "userId"))
    private List<User> teamMembers;
    @ManyToMany
    @JoinTable(
            name = "invitees",
            joinColumns = @JoinColumn(name = "teamId"),
            inverseJoinColumns = @JoinColumn(name = "userId"))
    private List<User> invited;
    @OneToMany
    @JoinColumn(name = "teamId")
    private List<Board> boards;

    public Team() {
    }

    public Long getId() {
        return teamId;
    }

    public void setId(Long id) {
        this.teamId = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamDescription() {
        return teamDescription;
    }

    public void setTeamDescription(String teamDescription) {
        this.teamDescription = teamDescription;
    }

    public List<User> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<User> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public List<User> getInvited() {
        return invited;
    }

    public void setInvited(List<User> invited) {
        this.invited = invited;
    }

    public List<Board> getBoards() {
        return boards;
    }

    public void setBoards(List<Board> boards) {
        this.boards = boards;
    }
}

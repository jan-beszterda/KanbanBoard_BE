package com.grupp3.ooad_projekt_backend.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String teamName;
    private String teamDescription;
    @ManyToMany
    @JoinTable(name = "user_team_invites",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "team_id"))
    private List<User> invited;

    @ManyToMany
    @JoinTable(name = "team_members",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id"))
    private List<User> members;

    @ManyToMany
    @JoinTable(name = "team_boards",
            joinColumns = @JoinColumn(name = "board_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id"))
    private List<Board> boards;



    public Team() {
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

    public List<User> getMembers() {
        return members;
    }

    public List<Board> getBoards() {
        return boards;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }


    public void addInvited(User user) {
        if(this.invited.contains(user)) return;
        this.invited.add(user);
    }

    public String getTeamDescription() {
        return teamDescription;
    }

    public void setTeamDescription(String teamDescription) {
        this.teamDescription = teamDescription;
    }

    public List<User> getInvited() {
        return invited;
    }

    public void setInvited(List<User> invited) {
        this.invited = invited;
    }

    public void addMember(User user) {
        this.invited.remove(user);
        this.members.add(user);
    }
}

package com.grupp3.ooad_projekt_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(	name = "users",
        uniqueConstraints = {
                /*@UniqueConstraint(columnNames = "username"),*/ @UniqueConstraint(columnNames = "email")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String firstName;
    private String lastName;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String email;
    @ManyToMany(mappedBy = "teamMembers")
    @JsonIgnore
    private List<Team> teams;

    @ManyToMany (mappedBy = "invited")
    @JsonIgnore
    private List<Team> invitations;

    public User(){}

    public List<Team> getInvitations() {
        return invitations;
    }

    public void setInvitations(List<Team> invitations) { this.invitations = invitations; }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long id) {
        this.userId = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}

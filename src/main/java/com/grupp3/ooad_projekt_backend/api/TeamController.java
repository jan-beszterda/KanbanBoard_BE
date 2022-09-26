package com.grupp3.ooad_projekt_backend.api;

import com.grupp3.ooad_projekt_backend.models.Team;
import com.grupp3.ooad_projekt_backend.models.User;
import com.grupp3.ooad_projekt_backend.service.TeamService;
import com.grupp3.ooad_projekt_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/api/team")
@AllArgsConstructor
public class TeamController {

    private final TeamService teamService;
    private final UserService userService;

    /**
     * Returns the team information by id
     * @param id
     * @return user or null
     */
    @GetMapping("/{team_id}")
    public Team getTeamById(@PathVariable("team_id") Long id) {
        /*Optional<Team> maybeTeam = teamService.getTeamById(id);
        if (maybeTeam.isEmpty()){
            return null;
        }*/
        return null;
    }

    /**
     * Returns "is invited" or "could not be invited".
     * @return string
     */
   /* @GetMapping("invite/{user_id}/{team_id}")
    public String inviteUserToTeam(@PathVariable("team_id") Long teamId, @PathVariable("team_id") Long userId) {
        Optional<Team> maybeTeam = teamService.getTeamById(teamId);
        if (maybeTeam.isEmpty()){
            return "Team could not be found.";
        }
        Team team = maybeTeam.get();

        Optional<User> maybeUser = userService.getUserById(userId);
        if (maybeUser.isEmpty()){
            return "User could not be found.";
        }
        User user = maybeUser.get();

        team.addInvited(user);

        return "User" + user.getUserName() + " is invited to team " + team.getTeamName();

    }*/

}

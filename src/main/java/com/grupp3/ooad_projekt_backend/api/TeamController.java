package com.grupp3.ooad_projekt_backend.api;

import com.grupp3.ooad_projekt_backend.models.Board;
import com.grupp3.ooad_projekt_backend.models.Team;
import com.grupp3.ooad_projekt_backend.models.User;
import com.grupp3.ooad_projekt_backend.service.TeamService;
import com.grupp3.ooad_projekt_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/team")
@AllArgsConstructor
public class TeamController {

    private final TeamService teamService;
    private final UserService userService;

    /**
     * Search for teams by name
     * @param teamName    teamName for the teams to find
     * @return list of teams
     */

    @GetMapping("/search_name/{team_name}")
    public List<Team> getTeamsByName(@PathVariable("team_name") String teamName) {
        return teamService.getTeamsByName(teamName);
    }

    /**
     * Returns the team information by id
     * @param id    teamId for the team requested
     * @return user or null
     */
    @GetMapping("/{team_id}")
    public Team getTeamById(@PathVariable("team_id") Long id) {
        return teamService.getTeamById(id);
    }

    /**
     * Returns "is invited" or "could not be invited".
     * @return string
     */
    @GetMapping("invite/{user_id}/{team_id}")
    public String inviteUserToTeam(@PathVariable("user_id") Long teamId, @PathVariable("team_id") Long userId) {
        Team team = teamService.getTeamById(teamId);
        if (team == null){
            return "Team could not be found.";
        }

        Optional<User> maybeUser = userService.getUserById(userId);
        if (maybeUser.isEmpty()){
            return "User could not be found.";
        }
        User user = maybeUser.get();

        team.getTeamMembers().add(user);

        return "User" + user.getUserName() + " is invited to team " + team.getTeamName();
    }

    @PostMapping("/new")
    public Team createTeam(@RequestBody Team newTeam) {
        return teamService.newTeam(newTeam);
    }

    @PostMapping
    public Team createTeam(@CookieValue(name = "userId") Long id, @RequestBody Team team) {
        return teamService.addTeam(id, team);
    }

    @GetMapping
    public List<Team> getTeamsByMemberId(@CookieValue(name = "userId") Long userId) {
        return teamService.getTeamsByMemberId(userId);
    }
}

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
    @PutMapping("{team_id}/invite")
    public String inviteUserToTeam(@PathVariable("team_id") Long teamId, @RequestParam("user_id") Long userId) {
        return teamService.inviteUserToTeam(teamId, userId);
    }

    @PostMapping
    public Team createTeam(@RequestParam("userId") Long userId, @RequestBody Team team) {
        return teamService.addTeam(userId, team);
    }

    @GetMapping
    public List<Team> getTeamsByMemberId(@RequestParam("userId") Long userId) {
        return teamService.getTeamsByMemberId(userId);
    }
}

package com.grupp3.ooad_projekt_backend.api;

import com.grupp3.ooad_projekt_backend.models.Team;
import com.grupp3.ooad_projekt_backend.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/team")
@AllArgsConstructor
public class TeamController {

    private final TeamService teamService;

    /**
     * Search for teams by name
     * @param teamName    teamName for the teams to find
     * @return list of teams
     */

    @GetMapping("/get_by_name")
    public List<Team> getTeamsByName(@RequestParam("team_name") String teamName) {
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
    @PutMapping("{team_id}/invite_user")
    //changed parameter to user_email
    public String inviteUserToTeam(@PathVariable("team_id") Long teamId, @RequestParam("user_email") String userEmail) {
        return teamService.inviteUserToTeam(teamId, userEmail);
    }

    @PutMapping("{team_id}/edit")
    public String editTeamName(@PathVariable("team_id") Long teamId, @RequestParam String teamName){
        return teamService.editTeamName(teamId,teamName);

    }

    /**
     * Removes user from team by id.
     * @return string
     */
    @PutMapping("{team_id}/leave")
    public String leaveTeam(@PathVariable("team_id") Long teamId, @RequestParam("user_id") Long userId) {
        return teamService.leaveTeam(teamId, userId);
    }

    @PostMapping
    public Team createTeam(@RequestParam("creator_id") Long userId, @RequestBody Team team) {
        return teamService.addTeam(userId, team);
    }

    @GetMapping("/for_user")
    public List<Team> getTeamsByMemberId(@RequestParam("user_id") Long userId) {
        return teamService.getTeamsByMemberId(userId);
    }
}

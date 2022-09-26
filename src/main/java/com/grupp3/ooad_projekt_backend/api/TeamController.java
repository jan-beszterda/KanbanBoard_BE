package com.grupp3.ooad_projekt_backend.api;

import com.grupp3.ooad_projekt_backend.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/team")
@AllArgsConstructor
public class TeamController {

    private final TeamService teamService;

}

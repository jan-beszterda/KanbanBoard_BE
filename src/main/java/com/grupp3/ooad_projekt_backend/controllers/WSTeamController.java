package com.grupp3.ooad_projekt_backend.controllers;

import com.grupp3.ooad_projekt_backend.message.Message;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WSTeamController {

    @MessageMapping("/team/{teamId}")
    @SendTo("/topic/team/{teamId}")
    public Message update(@DestinationVariable String teamId) {
        return new Message("true");
    }
}

package com.grupp3.ooad_projekt_backend.controllers;

import com.grupp3.ooad_projekt_backend.message.Message;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WSTeamListController {

    @MessageMapping("/teamlist/{userId}")
    @SendTo("/topic/teamlist/{userId}")
    public Message update(@DestinationVariable String userId) {
        return new Message("true");
    }
}

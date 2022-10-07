package com.grupp3.ooad_projekt_backend.controllers;

import com.grupp3.ooad_projekt_backend.message.Message;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Controller
public class WSBoardController {

    SimpMessagingTemplate simpMessagingTemplate;

    public WSBoardController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/board/{boardId}")
    @SendTo("/topic/board/{boardId}")
    public Message update(@DestinationVariable String boardId) {
        return new Message("true");

    }
}

package com.example.PhysioCenter.controller;

import com.example.PhysioCenter.domain.dto.message.MessageListDto;
import com.example.PhysioCenter.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api")
public class MessageApiController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientApiController.class);
    private MessageService messageService;

    public MessageApiController(MessageService messageService) {
        this.messageService = messageService;
    }

    @CrossOrigin
    @GetMapping(value = "/message/{userId}")
    public ResponseEntity<MessageListDto> getLastUserMessages(@PathVariable Long userId) {
        MessageListDto messageListDto = this.messageService.getLastMessages(userId);
        LOGGER.info("Get all messages");

        return new ResponseEntity<>(messageListDto, HttpStatus.OK);
    }
}
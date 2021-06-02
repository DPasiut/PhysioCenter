package com.example.PhysioCenter.controller;

import com.example.PhysioCenter.domain.dto.physioteraphist.PhysioDto;
import com.example.PhysioCenter.service.MessageService;
import com.example.PhysioCenter.service.PhysioService;
import com.example.PhysioCenter.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/api")
public class MessageApiController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientApiController.class);
    private MessageService messageService;

    public MessageApiController(MessageService messageService) {
        this.messageService = messageService;
    }


    @CrossOrigin
    @GetMapping(value = "/message")
    public ResponseEntity<Void> test() {
        LOGGER.info("Test connection");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
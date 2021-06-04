package com.example.PhysioCenter.controller;

import com.example.PhysioCenter.domain.dto.visit.VisitRoomDto;
import com.example.PhysioCenter.service.serviceImpl.RoomServiceImpl;
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

public class RoomApiController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientApiController.class);


    private final RoomServiceImpl roomService;

    public RoomApiController(RoomServiceImpl roomService) {
        this.roomService = roomService;
    }

    @CrossOrigin
    @GetMapping(value = "/room/{id}")
    public ResponseEntity<VisitRoomDto> getRoomById(@PathVariable Long id) {
        LOGGER.info("find room by id");

        VisitRoomDto visitsDto = roomService.getRoomById(id);
        return new ResponseEntity<>(visitsDto, HttpStatus.OK);
    }
}

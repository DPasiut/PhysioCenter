package com.example.PhysioCenter.controller;

import com.example.PhysioCenter.domain.dto.datePhysio.AddDatePhysioDto;
import com.example.PhysioCenter.domain.dto.datePhysio.DatePhysioDto;
import com.example.PhysioCenter.domain.dto.dateRoom.AddDateRoomDto;
import com.example.PhysioCenter.domain.dto.dateRoom.DateRoomDto;
import com.example.PhysioCenter.domain.entity.DateRoom;
import com.example.PhysioCenter.service.DateRoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/api")

public class DateRoomController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientApiController.class);

    private final DateRoomService dateRoomService;

    public DateRoomController(DateRoomService dateRoomService) {
        this.dateRoomService = dateRoomService;
    }

    @CrossOrigin
    @GetMapping(value = "/dates-room")
    public ResponseEntity<List<DateRoomDto>> getAllDatesRooms() {
        LOGGER.info("find all dates-rooms");

        List<DateRoomDto> roomDto = dateRoomService.getAll();
        return new ResponseEntity<>(roomDto, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/dates-room-id/{id}")
    public ResponseEntity<List<DateRoomDto>> getAllDatesRoomsById(@PathVariable Long id) {
        LOGGER.info("find all dates-rooms by id");

        List<DateRoomDto> roomDto = dateRoomService.getByRoomId(id);
        return new ResponseEntity<>(roomDto, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/dates-rooms-available/{id}")
    public ResponseEntity<List<DateRoomDto>> getAllAvailableDatesRoomsById(@PathVariable Long id) {
        LOGGER.info("find all available dates-rooms by id");

        List<DateRoomDto> roomDto = dateRoomService.getAvailableDatesByRoomId(id);
        return new ResponseEntity<>(roomDto, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/dates-room-available-all")
    public ResponseEntity<List<DateRoomDto>> getAllAvailableDatesRooms() {
        LOGGER.info("find all available dates-rooms");

        List<DateRoomDto> roomDto = dateRoomService.getAllAvailableDatesRooms();
        return new ResponseEntity<>(roomDto, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/dates-room/add")
    public ResponseEntity<DateRoomDto> addRoom(@RequestBody AddDateRoomDto addDateRoomDto){
        LOGGER.info("Adding date_room");

        DateRoomDto roomDto = dateRoomService.addDateRoom(addDateRoomDto);

        return new ResponseEntity<>(roomDto, HttpStatus.OK);
    }
}

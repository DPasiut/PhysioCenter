package com.example.PhysioCenter.controller;

import com.example.PhysioCenter.domain.dto.datePhysio.AddDatePhysioDto;
import com.example.PhysioCenter.domain.dto.datePhysio.DatePhysioDto;
import com.example.PhysioCenter.domain.dto.visit.AddDateDto;
import com.example.PhysioCenter.domain.dto.visit.DateOfTheVisitDto;
import com.example.PhysioCenter.domain.entity.DatePhysio;
import com.example.PhysioCenter.service.serviceImpl.DatePhysioServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/api")

public class DatePhysioApiController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientApiController.class);

    private final DatePhysioServiceImpl datePhysioService;

    public DatePhysioApiController(DatePhysioServiceImpl datePhysioService) {
        this.datePhysioService = datePhysioService;
    }

    @CrossOrigin
    @GetMapping(value = "/dates-physio")
    public ResponseEntity<List<DatePhysioDto>> getAllDatesPhysio() {
        LOGGER.info("find all dates-physio");

        List<DatePhysioDto> visitsDto = datePhysioService.getAll();
        return new ResponseEntity<>(visitsDto, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/dates-physio-id/{id}")
    public ResponseEntity<List<DatePhysioDto>> getAllDatesPhysioById(@PathVariable Long id) {
        LOGGER.info("find all dates-physio by id");

        List<DatePhysioDto> visitsDto = datePhysioService.getByPhysioId(id);
        return new ResponseEntity<>(visitsDto, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/dates-physio-available/{id}")
    public ResponseEntity<List<DatePhysioDto>> getAllAvailableDatesPhysioById(@PathVariable Long id) {
        LOGGER.info("find all available dates-physio by id");

        List<DatePhysioDto> visitsDto = datePhysioService.getAvailableDatesByPhysioId(id);
        return new ResponseEntity<>(visitsDto, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/dates-physio-available-all")
    public ResponseEntity<List<DatePhysioDto>> getAllAvailableDatesPhysio() {
        LOGGER.info("find all available dates-physio by id");

        List<DatePhysioDto> visitsDto = datePhysioService.getAllAvailableDatesPhysio();
        return new ResponseEntity<>(visitsDto, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/dates-physio/add")
    public ResponseEntity<DatePhysioDto> addDate(@RequestBody AddDatePhysioDto datePhysioDto){
        LOGGER.info("Adding date_physio");

        DatePhysioDto dateDto = datePhysioService.addDatePhysio(datePhysioDto);

        return new ResponseEntity<>(dateDto, HttpStatus.OK);
    }
}

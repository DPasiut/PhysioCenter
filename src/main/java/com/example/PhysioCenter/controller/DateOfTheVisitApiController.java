package com.example.PhysioCenter.controller;

import com.example.PhysioCenter.domain.dto.visit.AddDateDto;
import com.example.PhysioCenter.domain.dto.visit.DateOfTheVisitDto;
import com.example.PhysioCenter.domain.entity.DateOfTheVisit;
import com.example.PhysioCenter.service.serviceImpl.DateOfTheVisitImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(value = "/api")

public class DateOfTheVisitApiController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientApiController.class);

    private final DateOfTheVisitImpl dateOfTheVisit;

    public DateOfTheVisitApiController(DateOfTheVisitImpl dateOfTheVisit) {
        this.dateOfTheVisit = dateOfTheVisit;
    }


    @CrossOrigin
    @GetMapping(value = "/visits-dates")
    public ResponseEntity<List<DateOfTheVisitDto>> getAllVisitsDates() {
        LOGGER.info("find all visits dates");

        List<DateOfTheVisitDto> visitsDto = dateOfTheVisit.findAll();
        return new ResponseEntity<>(visitsDto, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/visit-date/{date}")
    public ResponseEntity<List<DateOfTheVisitDto>> getDatesByDay(
            @PathVariable
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

        LOGGER.info("find visit date by day");

        List<DateOfTheVisitDto> visitsDto = dateOfTheVisit.getVisitsDatesByDay(date);
        return new ResponseEntity<>(visitsDto, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/visit-id/{id}")
    public ResponseEntity<DateOfTheVisitDto> getDateById(
            @PathVariable Long id) {

        LOGGER.info("find date by id");

        DateOfTheVisitDto visitsDto = dateOfTheVisit.getDateById(id);
        return new ResponseEntity<>(visitsDto, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/visit-date/add")
    public ResponseEntity<DateOfTheVisitDto> addDate(@RequestBody AddDateDto dateDto){
        LOGGER.info("Adding date of the visit: " + dateDto);

        DateOfTheVisitDto dateOfTheVisitDto = dateOfTheVisit.addDate(dateDto);

        return new ResponseEntity<>(dateOfTheVisitDto, HttpStatus.OK);
    }

}

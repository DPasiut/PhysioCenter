package com.example.PhysioCenter.controller;


import com.example.PhysioCenter.domain.dto.visit.VisitDto;
import com.example.PhysioCenter.domain.dto.visit.VisitRoomDto;
import com.example.PhysioCenter.service.serviceImpl.VisitServiceImpl;
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

public class VisitApiController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientApiController.class);

    private final VisitServiceImpl visitService;

    public VisitApiController(VisitServiceImpl visitService) {
        this.visitService = visitService;
    }

    @CrossOrigin
    @GetMapping(value = "/visit/{id}")
    public ResponseEntity<VisitDto> getVisitById(@PathVariable String id) {
        LOGGER.info("find visit by id");

        VisitDto visitDto = visitService.getVisitById(id);
        return new ResponseEntity<>(visitDto, HttpStatus.OK);
    }
}

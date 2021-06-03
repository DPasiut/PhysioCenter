package com.example.PhysioCenter.controller;


import com.example.PhysioCenter.domain.dto.visit.CreateVisitDto;
import com.example.PhysioCenter.domain.dto.visit.VisitDto;
import com.example.PhysioCenter.service.serviceImpl.VisitServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity<VisitDto> getVisitById(@PathVariable Long id) {
        LOGGER.info("find visit by id");

        VisitDto visitDto = visitService.getVisitById(id);
        return new ResponseEntity<>(visitDto, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "visit/add")
    public ResponseEntity<CreateVisitDto> addVisit(@RequestBody CreateVisitDto createVisitDto){
        LOGGER.info("create new visit");

        CreateVisitDto visitDto = visitService.addVisit(createVisitDto);
        return new ResponseEntity<>(visitDto, HttpStatus.OK);
    }
}

package com.example.PhysioCenter.controller;

import com.example.PhysioCenter.domain.dto.patient.PatientDto;
import com.example.PhysioCenter.domain.dto.physioteraphist.PhysioDto;
import com.example.PhysioCenter.domain.exceptions.PhysioNotFoundException;
import com.example.PhysioCenter.service.PhysioService;
import com.example.PhysioCenter.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/api")
public class PhysioApiController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientApiController.class);

    private final PhysioService physioService;
    private final UserService userService;

    public PhysioApiController(PhysioService physioService, UserService userService) {
        this.physioService = physioService;
        this.userService = userService;
    }


    @CrossOrigin
    @GetMapping(value = "/physio")
    public ResponseEntity<List<PhysioDto>> getPhysio() {
        LOGGER.info("find all physio");

        List<PhysioDto> physioDto = physioService.findAll();
        return new ResponseEntity<>(physioDto, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/physio/{id}")
    public ResponseEntity<PhysioDto> getPhysioById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(physioService.getPhysioById(id), HttpStatus.OK);
        }catch (PhysioNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

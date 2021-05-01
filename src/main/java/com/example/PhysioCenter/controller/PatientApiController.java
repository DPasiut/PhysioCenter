package com.example.PhysioCenter.controller;

import com.example.PhysioCenter.domain.dto.patient.PatientDto;
import com.example.PhysioCenter.domain.dto.patient.PatientNotFoundException;
import com.example.PhysioCenter.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@Controller
@RequestMapping(value = "/api")
public class PatientApiController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientApiController.class);

    private final PatientService patientService;

    public PatientApiController(PatientService patientService) {
        this.patientService = patientService;
    }

    @CrossOrigin
    @GetMapping(value = "/patients")
    public ResponseEntity<List<PatientDto>> getPatients(){
        LOGGER.info("find all patients");

        List<PatientDto> patientDto = patientService.findAll();
        return new ResponseEntity<>(patientDto, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "patients/{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable Long id){
        LOGGER.info("get patient by id" + id);

        try {
            LOGGER.info("Patient of id " + id + " found");
            return new ResponseEntity<>(patientService.getPatientById(id), HttpStatus.OK);
        }catch (PatientNotFoundException e){
            LOGGER.info("No patient of id " + id + " found");
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}

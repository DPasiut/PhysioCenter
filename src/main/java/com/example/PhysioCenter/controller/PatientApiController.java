package com.example.PhysioCenter.controller;

import com.example.PhysioCenter.domain.dto.patient.PatientDto;
import com.example.PhysioCenter.domain.dto.users.RegisterPatientUserResponseDto;
import com.example.PhysioCenter.domain.exceptions.LoginDuplicatedException;
import com.example.PhysioCenter.domain.exceptions.PatientNotCreatedException;
import com.example.PhysioCenter.domain.dto.users.CreatePatientUserDto;
import com.example.PhysioCenter.domain.dto.users.UserDto;
import com.example.PhysioCenter.domain.exceptions.UserNotCreatedException;
import com.example.PhysioCenter.service.PatientService;
import com.example.PhysioCenter.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/api")
public class PatientApiController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientApiController.class);

    private final PatientService patientService;
    private final UserService userService;

    public PatientApiController(PatientService patientService, UserService userService) {
        this.patientService = patientService;
        this.userService = userService;
    }

    @CrossOrigin
    @GetMapping(value = "/patients")
    public ResponseEntity<List<PatientDto>> getPatients() {
        LOGGER.info("find all patients");

        List<PatientDto> patientDto = patientService.findAll();
        return new ResponseEntity<>(patientDto, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/patients/{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable Long id) {
        return new ResponseEntity<>(patientService.getPatientById(id), HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/patients/{id}")
    public ResponseEntity<Void> updatePatient(@RequestBody PatientDto patientDto, @PathVariable Long id) {
        patientService.updatePatient(patientDto, id);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin
    @DeleteMapping("/patients/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable("id") Long id) {
        patientService.deletePatientById(id);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin
    @PostMapping("/auth/register/patient")
    public ResponseEntity<RegisterPatientUserResponseDto> createUser(@RequestBody CreatePatientUserDto createPatientUserDto) throws UserNotCreatedException, PatientNotCreatedException, LoginDuplicatedException {
        LOGGER.info("--- create user account for patient: " + createPatientUserDto.toString());

        RegisterPatientUserResponseDto registrationResponsse = null;
        try {
            registrationResponsse.toBuilder()
                    .userDto(userService.createPatientUser(createPatientUserDto))
                    .build();
        } catch (LoginDuplicatedException exception) {
            return new ResponseEntity<>(
                    registrationResponsse.toBuilder()
                            .message(exception.getMessage())
                            .build(),
                    HttpStatus.BAD_REQUEST
            );
        }

        return new ResponseEntity<>(registrationResponsse, HttpStatus.OK);
    }
}

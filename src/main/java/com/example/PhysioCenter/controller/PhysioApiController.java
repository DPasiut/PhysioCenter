package com.example.PhysioCenter.controller;

import com.example.PhysioCenter.domain.dto.physioteraphist.PhysioDto;
import com.example.PhysioCenter.domain.exceptions.PhysioNotCreatedException;
import com.example.PhysioCenter.domain.exceptions.PhysioNotFoundException;
import com.example.PhysioCenter.service.PhysioService;
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
    public ResponseEntity<PhysioDto> getPhysioById(@PathVariable Long id) throws PhysioNotFoundException {
        try {
            return new ResponseEntity<>(physioService.getPhysioById(id), HttpStatus.OK);
        }catch (PhysioNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @PutMapping("/physio/{id}")
    public ResponseEntity<PhysioDto> updatePhysio(@RequestBody PhysioDto physioDto, @PathVariable Long id) throws PhysioNotFoundException {
        try {
            PhysioDto physio = physioService.updatePhysio(physioDto, id);
            return new ResponseEntity<>(physio, HttpStatus.OK);
        }catch (PhysioNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @PostMapping("/physio")
    public ResponseEntity<PhysioDto> createPhysio(@RequestBody PhysioDto physioDto) throws PhysioNotCreatedException {
        return new ResponseEntity<>(physioService.addPhysio(physioDto), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/physio/{id}")
    public ResponseEntity<Boolean> deletePhysio(@PathVariable Long id) {
        return new ResponseEntity<>(physioService.deletePhysioById(id), HttpStatus.OK);
    }
}

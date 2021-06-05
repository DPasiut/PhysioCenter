package com.example.PhysioCenter.controller;

import com.example.PhysioCenter.domain.dto.visit.AvailableVisitDto;
import com.example.PhysioCenter.domain.dto.visit.RegisterVisitDto;
import com.example.PhysioCenter.service.serviceImpl.TempVisitServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@Controller
@RequestMapping(value = "/api")
public class TempVisitApiController {
    private TempVisitServiceImpl tempVisitService;

    public TempVisitApiController(TempVisitServiceImpl tempVisitService) {
        this.tempVisitService = tempVisitService;
    }

    @CrossOrigin
    @GetMapping(value = "/visits/{physioId}/{date}")
    public ResponseEntity<List<AvailableVisitDto>> getDatesByDay(@PathVariable Long physioId, @PathVariable String date) {

        List<AvailableVisitDto> visitsDto = tempVisitService.getVisitsDatesByDay(physioId, date);
        return new ResponseEntity<>(visitsDto, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/visit/{physioId}")
    public ResponseEntity<AvailableVisitDto> registerVisitByDate(@PathVariable Long physioId, @RequestBody RegisterVisitDto registerVisitDto) {
        AvailableVisitDto availableVisitDto = tempVisitService.registerVisitByDate(physioId, registerVisitDto);
        return new ResponseEntity<>(availableVisitDto, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/visit/{physioId}/cancel")
    public ResponseEntity<AvailableVisitDto> cancelVisit(@PathVariable Long physioId, @RequestBody RegisterVisitDto registerVisitDto) {
        AvailableVisitDto availableVisitDto = tempVisitService.cancelVisit(physioId, registerVisitDto);
        return new ResponseEntity<>(availableVisitDto, HttpStatus.OK);
    }
}

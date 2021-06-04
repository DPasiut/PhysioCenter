package com.example.PhysioCenter.controller;


import com.example.PhysioCenter.domain.dto.visit.DateOfTheVisitDto;
import com.example.PhysioCenter.domain.dto.visit.TempVisitDto;
import com.example.PhysioCenter.service.serviceImpl.TempVisitServiceImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
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
    public ResponseEntity<List<TempVisitDto>> getDatesByDay(
            @PathVariable Long physioId,
            //   @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate
            @PathVariable String date) {

        List<TempVisitDto> visitsDto = tempVisitService.getVisitsDatesByDay(physioId, date);
        return new ResponseEntity<>(visitsDto, HttpStatus.OK);
    }
}

package com.example.PhysioCenter.controller;


import com.example.PhysioCenter.domain.dto.physioteraphist.PhysioDto;
import com.example.PhysioCenter.domain.dto.visit.DateOfTheVisitDto;
import com.example.PhysioCenter.domain.entity.DateOfTheVisit;
import com.example.PhysioCenter.service.serviceImpl.DateOfTheVisitImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/api")

public class VisitApiController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientApiController.class);
}

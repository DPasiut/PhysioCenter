package com.example.PhysioCenter.service;

import com.example.PhysioCenter.domain.dto.visit.CreateVisitDto;
import com.example.PhysioCenter.domain.dto.visit.VisitDto;

import java.util.Date;
import java.util.List;

public interface VisitService {
    List<VisitDto> findAll();
    VisitDto getVisitById(Long id);
    List<VisitDto> getVisitByPatientId(Long id);
    List<VisitDto> getVisitByPhysioId(Long id);
    List<VisitDto> getVisitByDate(Date date);
    List<VisitDto> getVisitBetweenDates(Date from, Date to);
    CreateVisitDto addVisit(CreateVisitDto createVisitDto);
}

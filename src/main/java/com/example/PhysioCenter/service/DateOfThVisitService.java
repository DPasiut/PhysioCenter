package com.example.PhysioCenter.service;

import com.example.PhysioCenter.domain.dto.visit.DateOfTheVisitDto;

import java.time.LocalDate;
import java.util.List;

public interface DateOfThVisitService {
    List<DateOfTheVisitDto> findAll();
    List<DateOfTheVisitDto> getVisitsDatesByDay(LocalDate date);
    DateOfTheVisitDto getDateById (Long id);
}

package com.example.PhysioCenter.service.serviceImpl;

import com.example.PhysioCenter.domain.dto.visit.DateOfTheVisitDto;
import com.example.PhysioCenter.domain.entity.DateOfTheVisit;
import com.example.PhysioCenter.domain.repository.DateOfTheVisitRepository;
import com.example.PhysioCenter.service.DateOfThVisitService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DateOfTheVisitImpl implements DateOfThVisitService {

    private final DateOfTheVisitRepository dateOfTheVisitRepository;

    public DateOfTheVisitImpl(DateOfTheVisitRepository dateOfTheVisitRepository) {
        this.dateOfTheVisitRepository = dateOfTheVisitRepository;
    }

    @Override
    public List<DateOfTheVisitDto> findAll() {
        return StreamSupport.stream(dateOfTheVisitRepository
                .findAll().spliterator(), false)
                .map(DateOfTheVisit::dto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DateOfTheVisitDto> getVisitsDatesByDay(LocalDate date) {
        return StreamSupport.stream(dateOfTheVisitRepository
                .findAll().spliterator(), false)
                .filter(dateOfTheVisit -> dateOfTheVisit.getDateRange().lower().toLocalDate().equals(date))
                .map(DateOfTheVisit::dto)
                .collect(Collectors.toList());
    }

    @Override
    public DateOfTheVisitDto getDateById(Long id) {
        return dateOfTheVisitRepository.findById(id).get().dto();
    }
}

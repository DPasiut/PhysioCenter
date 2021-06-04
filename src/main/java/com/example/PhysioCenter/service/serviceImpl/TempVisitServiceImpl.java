package com.example.PhysioCenter.service.serviceImpl;

import com.example.PhysioCenter.controller.PatientApiController;
import com.example.PhysioCenter.domain.dto.visit.TempVisitDto;
import com.example.PhysioCenter.domain.entity.Message;
import com.example.PhysioCenter.domain.entity.TempVisit;
import com.example.PhysioCenter.domain.entity.Visit;
import com.example.PhysioCenter.domain.repository.TempVisitRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TempVisitServiceImpl {
    private TempVisitRepository tempVisitRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientApiController.class);


    public TempVisitServiceImpl(TempVisitRepository tempVisitRepository) {
        this.tempVisitRepository = tempVisitRepository;
    }

    public List<TempVisitDto> getVisitsDatesByDay(Long physioId, String date) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            LocalDate datetime = LocalDate.parse(date, pattern);
            LOGGER.info(String.valueOf(datetime));

            return StreamSupport.stream(tempVisitRepository
                    .getVisitsToPhysioByDate(physioId, datetime)
                    .spliterator(), false)
                    .map(TempVisit::dto)
                    .collect(Collectors.toList());
        } catch (DateTimeParseException e) {
            LOGGER.info(String.valueOf(e));
        }

        return null;
    }
}

package com.example.PhysioCenter.service.serviceImpl;

import com.example.PhysioCenter.controller.PatientApiController;
import com.example.PhysioCenter.domain.dto.visit.AvailableVisitDto;
import com.example.PhysioCenter.domain.dto.visit.RegisterVisitDto;
import com.example.PhysioCenter.domain.entity.TempVisit;
import com.example.PhysioCenter.domain.exceptions.VisitNotRegistered;
import com.example.PhysioCenter.domain.repository.TempVisitRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TempVisitServiceImpl {
    private TempVisitRepository tempVisitRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientApiController.class);


    public TempVisitServiceImpl(TempVisitRepository tempVisitRepository) {
        this.tempVisitRepository = tempVisitRepository;
    }

    private List<AvailableVisitDto> prepareListOfVisits(String datetime, Long physioId) {
        List<AvailableVisitDto> allVisits = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            int hour = 8 + i;
            String startH = hour >= 10 ? String.valueOf(hour) : "0" + hour;
            String timeFrom = startH + ":00:00";
            String timeTo = startH + ":30:00";
            AvailableVisitDto visit = new AvailableVisitDto();
            visit.setPhysioId(physioId);
            visit.setDate(datetime);
            visit.setTimeFrom(timeFrom);
            visit.setTimeTo(timeTo);
            visit.setFree(true);
            allVisits.add(visit);


            visit = new AvailableVisitDto();
            String startH2 = hour >= 10 ? String.valueOf(hour) : "0" + hour;
            String endH = hour + 1 >= 10 ? String.valueOf(hour + 1) : "0" + (hour + 1);
            String timeFrom2 = startH2 + ":30:00";
            String timeTo2 = endH + ":00:00";
            visit.setPhysioId(physioId);
            visit.setDate(datetime);
            visit.setTimeFrom(timeFrom2);
            visit.setTimeTo(timeTo2);
            visit.setFree(true);
            allVisits.add(visit);
        }

        return allVisits;
    }

    public List<AvailableVisitDto> getVisitsDatesByDay(Long physioId, String date) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            LocalDate datetime = LocalDate.parse(date, pattern);
            List<AvailableVisitDto> availableVisitsDto = prepareListOfVisits(datetime.toString(), physioId);
            List<TempVisit> freeVisits = tempVisitRepository.getVisitsToPhysioByDate(physioId, datetime);

            for (TempVisit visit: freeVisits) {
                for (AvailableVisitDto available: availableVisitsDto) {
                    if (visit.getTimeFrom().equals(available.getTimeFrom()) && visit.getTimeTo().equals(available.getTimeTo())) {
                        available.setFree(false);
                        LOGGER.info("c" + visit.getPatientId());
                        available.setPatientId(visit.getPatientId());
                        break;
                    }
                }
            }

            return availableVisitsDto;
        } catch (DateTimeParseException e) {
            LOGGER.info(String.valueOf(e));
        }

        return null;
    }

    public AvailableVisitDto registerVisitByDate(Long physioId, RegisterVisitDto registerVisitDto) {
        LocalDate localDate = LocalDate.parse(registerVisitDto.getDate());
        Time from = Time.valueOf(registerVisitDto.getTimeFrom());
        Time to = Time.valueOf(registerVisitDto.getTimeTo());
        TempVisit tempVisit = tempVisitRepository.getVisit(physioId, localDate, from, to);
        if (tempVisit == null || tempVisit.getFree() != false) {
            tempVisitRepository.registerVisit(physioId, registerVisitDto.getPatientId(), localDate, from, to);
            tempVisit = tempVisitRepository.getVisit(physioId, localDate, from, to);
            if (tempVisit != null) {
                return new AvailableVisitDto(
                        tempVisit.getTimeFrom(),
                        tempVisit.getTimeTo(),
                        registerVisitDto.getDate(),
                        tempVisit.getPhysioId(),
                        registerVisitDto.getPatientId(),
                        tempVisit.getFree()
                );
            }

            return null;
        }

        throw new VisitNotRegistered(physioId);
    }
}

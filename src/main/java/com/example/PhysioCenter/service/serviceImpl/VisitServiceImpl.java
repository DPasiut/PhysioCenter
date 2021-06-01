package com.example.PhysioCenter.service.serviceImpl;

import com.example.PhysioCenter.domain.dto.patient.PatientDto;
import com.example.PhysioCenter.domain.dto.physioteraphist.PhysioDto;
import com.example.PhysioCenter.domain.dto.visit.DateOfTheVisitDto;
import com.example.PhysioCenter.domain.dto.visit.VisitDto;
import com.example.PhysioCenter.domain.dto.visit.VisitRoomDto;
import com.example.PhysioCenter.domain.entity.DateOfTheVisit;
import com.example.PhysioCenter.domain.entity.Visit;
import com.example.PhysioCenter.domain.repository.*;
import com.example.PhysioCenter.service.VisitService;
import com.vladmihalcea.hibernate.type.range.Range;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;

    private final PatientServiceImpl patientService;
    private final PhysioServiceImpl physioService;
    private final DateOfTheVisitImpl dateOfTheVisit;
    private final RoomServiceImpl roomService;
    private final DateOfTheVisitRepository dateOfTheVisitRepository;

    public VisitServiceImpl(VisitRepository visitRepository, PatientServiceImpl patientService, PhysioServiceImpl physioService, DateOfTheVisitImpl dateOfTheVisit, RoomServiceImpl roomService, DateOfTheVisitRepository dateOfTheVisitRepository) {
        this.visitRepository = visitRepository;
        this.patientService = patientService;
        this.physioService = physioService;
        this.dateOfTheVisit = dateOfTheVisit;
        this.roomService = roomService;
        this.dateOfTheVisitRepository = dateOfTheVisitRepository;
    }

    @Override
    public List<VisitDto> findAll() {

        return null;
    }

    @Override
    public VisitDto getVisitById(String id) {
        Visit visit = visitRepository.findById(id).get();

        PatientDto patientDto = patientService.getPatientById(visit.getPatientId());
        PhysioDto physioDto = physioService.getPhysioById(visit.getPhysioId());
        Range<LocalDateTime> dateOfTheVisit = dateOfTheVisitRepository.findById(visit.getDateId()).get().getDateRange();
        VisitRoomDto visitRoomDto = roomService.getRoomById(visit.getRoomId());

        return VisitDto.builder()
                .patientName(patientDto.getName())
                .patientSurname(patientDto.getSurname())
                .physioName(physioDto.getName())
                .physioSurname(physioDto.getSurname())
                .roomNumber(visitRoomDto.getRoomNumber())
                .date(dateOfTheVisit.lower().toLocalDate().toString())
                .hourFrom(dateOfTheVisit.lower().toLocalTime().toString())
                .hourTo(dateOfTheVisit.upper().toLocalTime().toString())
                .build();
    }

    @Override
    public List<VisitDto> getVisitByPatientId(Long id) {
        return null;
    }

    @Override
    public List<VisitDto> getVisitByPhysioId(Long id) {
        return null;
    }

    @Override
    public List<VisitDto> getVisitByDate(Date date) {
        return null;
    }

    @Override
    public List<VisitDto> getVisitBetweenDates(Date from, Date to) {
        return null;
    }
}

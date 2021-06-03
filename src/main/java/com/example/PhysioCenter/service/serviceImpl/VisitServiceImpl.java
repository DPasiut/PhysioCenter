package com.example.PhysioCenter.service.serviceImpl;

import com.example.PhysioCenter.domain.dto.patient.PatientDto;
import com.example.PhysioCenter.domain.dto.physioteraphist.PhysioDto;
import com.example.PhysioCenter.domain.dto.visit.CreateVisitDto;
import com.example.PhysioCenter.domain.dto.visit.VisitDto;
import com.example.PhysioCenter.domain.dto.visit.VisitRoomDto;
import com.example.PhysioCenter.domain.entity.*;
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
    private final RoomServiceImpl roomService;
    private final DateOfTheVisitRepository dateOfTheVisitRepository;
    private final DateRoomRepository dateRoomRepository;
    private final DatePhysioRepository datePhysioRepository;


    public VisitServiceImpl(VisitRepository visitRepository, PatientServiceImpl patientService, PhysioServiceImpl physioService, DateOfTheVisitImpl dateOfTheVisit, RoomServiceImpl roomService, DateOfTheVisitRepository dateOfTheVisitRepository, DateRoomRepository dateRoomRepository, DatePhysioRepository datePhysioRepository) {
        this.visitRepository = visitRepository;
        this.patientService = patientService;
        this.physioService = physioService;
        this.roomService = roomService;
        this.dateOfTheVisitRepository = dateOfTheVisitRepository;
        this.dateRoomRepository = dateRoomRepository;
        this.datePhysioRepository = datePhysioRepository;
    }

    @Override
    public List<VisitDto> findAll() {
        return null;
    }

    @Override
    public VisitDto getVisitById(Long id) {
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

    @Override
    public CreateVisitDto addVisit(CreateVisitDto createVisitDto) {

        Visit createdVisit = new Visit();
        try {
            createdVisit = visitRepository.save(
                    new Visit().toBuilder()
                            .patientId(createVisitDto.getPatientId())
                            .physioId(createVisitDto.getPhysioId())
                            .dateId(createVisitDto.getDateId())
                            .roomId(createVisitDto.getRoomId())
                            .build()
            );

            DatePhysio datePhysio = datePhysioRepository.findById(
                    new DatePhysioId(createVisitDto.getPhysioId(), createdVisit.getDateId())).get();
            DateRoom dateRoom = dateRoomRepository.findById(
                    new DateRoomId(createVisitDto.getDateId(), createVisitDto.getRoomId())
            ).get();

            datePhysio.setIsAvailable(false);
            dateRoom.setIsAvailable(false);

            datePhysioRepository.save(datePhysio);
            dateRoomRepository.save(dateRoom);

        }catch (Exception e){
            System.out.println("Something went wrong at save new Visit");
        }


        CreateVisitDto visitDto = new CreateVisitDto().toBuilder()
                .dateId(createdVisit.getDateId())
                .patientId(createdVisit.getPatientId())
                .physioId(createdVisit.getPhysioId())
                .roomId(createdVisit.getRoomId())
                .build();

        return visitDto ;
    }
}

package com.example.PhysioCenter.service.serviceImpl;

import com.example.PhysioCenter.domain.dto.visit.VisitDto;
import com.example.PhysioCenter.domain.entity.Visit;
import com.example.PhysioCenter.domain.repository.PatientRepository;
import com.example.PhysioCenter.domain.repository.PhysioRepository;
import com.example.PhysioCenter.domain.repository.VisitRepository;
import com.example.PhysioCenter.service.VisitService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;
    private final PatientRepository patientRepository;
    private final PhysioRepository physioRepository;

    public VisitServiceImpl(VisitRepository visitRepository, PatientRepository patientRepository, PhysioRepository physioRepository) {
        this.visitRepository = visitRepository;
        this.patientRepository = patientRepository;
        this.physioRepository = physioRepository;
    }

    @Override
    public List<VisitDto> findAll() {

        return null;
    }

    @Override
    public VisitDto getVisitById(Long id) {
        Visit visit = visitRepository.findById(id).get();

        return VisitDto.builder()
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

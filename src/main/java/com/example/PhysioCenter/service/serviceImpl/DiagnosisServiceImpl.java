package com.example.PhysioCenter.service.serviceImpl;

import com.example.PhysioCenter.domain.dto.diagnosis.DiagnosisDto;
import com.example.PhysioCenter.domain.entity.Diagnosis;
import com.example.PhysioCenter.domain.repository.DiagnosisRepository;
import com.example.PhysioCenter.service.DiagnosisService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {

    private final DiagnosisRepository diagnosisRepository;

    public DiagnosisServiceImpl(DiagnosisRepository diagnosisRepository) {
        this.diagnosisRepository = diagnosisRepository;
    }

    @Override
    public List<DiagnosisDto> getAllByPatientId(Long id) {
        return StreamSupport.stream(diagnosisRepository
                .findAll().spliterator(), false)
                .filter(diagnosis -> diagnosis.getPatientId().equals(id))
                .map(Diagnosis::dto)
                .collect(Collectors.toList());
    }
}

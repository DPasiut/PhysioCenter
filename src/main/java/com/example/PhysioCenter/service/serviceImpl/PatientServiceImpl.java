package com.example.PhysioCenter.service.serviceImpl;

import com.example.PhysioCenter.domain.dto.PatientDto;
import com.example.PhysioCenter.domain.entity.Patient;
import com.example.PhysioCenter.domain.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.PhysioCenter.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatientServiceImpl.class);

    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<PatientDto> findAll() {
        return patientRepository
                .findAll().stream()
                .map(Patient::dto)
                .collect(Collectors.toList());
    }

}

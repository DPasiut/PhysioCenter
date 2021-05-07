package com.example.PhysioCenter.service;

import com.example.PhysioCenter.domain.dto.patient.PatientDto;

import java.util.List;

public interface PatientService {
    List<PatientDto> findAll();

    PatientDto getPatientById(Long id);

    void updatePatient(PatientDto patient, Long id);

    boolean deletePatientById(Long id);
}

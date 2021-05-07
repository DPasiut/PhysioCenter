package com.example.PhysioCenter.service;

import com.example.PhysioCenter.domain.dto.patient.PatientDto;
import com.example.PhysioCenter.domain.entity.Patient;
import java.util.List;
import java.util.Optional;

public interface PatientService {
    List<PatientDto> findAll();
    PatientDto getPatientById(Long id);
    void updatePatient(PatientDto patient, Long id);
    boolean deletePatientById(Long id);
    Optional<Patient> findPatientById(Long id);
    Patient addPatient(Patient patient);
}

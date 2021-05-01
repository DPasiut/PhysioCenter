package com.example.PhysioCenter.service;

import com.example.PhysioCenter.domain.dto.patient.PatientDto;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface PatientService {
    List<PatientDto> findAll();
    PatientDto getPatientById(Long id);
    void updatePatient(PatientDto patient);
    void deletePatientById(Long id);

}

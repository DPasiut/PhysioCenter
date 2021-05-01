package com.example.PhysioCenter.service;

import com.example.PhysioCenter.domain.dto.patient.PatientDto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface PatientService {
    List<PatientDto> findAll();
}

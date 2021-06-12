package com.example.PhysioCenter.service;

import com.example.PhysioCenter.domain.dto.diagnosis.DiagnosisDto;
import com.example.PhysioCenter.domain.dto.exercise.ExerciseDto;

import java.util.List;

public interface DiagnosisService {
    List<DiagnosisDto> getAllByPatientId(Long id);
    //DiagnosisDto addDiagnosis(Long patientId, Long physioId, String diagnosis);
    List<ExerciseDto> getAllExercisesByDiagnosisId(Long id);
}

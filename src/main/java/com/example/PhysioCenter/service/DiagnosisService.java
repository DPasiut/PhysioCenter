package com.example.PhysioCenter.service;

import com.example.PhysioCenter.domain.dto.diagnosis.AddDiagnosisDto;
import com.example.PhysioCenter.domain.dto.diagnosis.DiagnosisDto;
import com.example.PhysioCenter.domain.dto.exercise.ExerciseDto;

import java.util.List;

public interface DiagnosisService {
    List<DiagnosisDto> getAllByPatientId(Long id);
    DiagnosisDto addDiagnosis(AddDiagnosisDto addDiagnosisDto);
    List<ExerciseDto> getAllExercisesByDiagnosisId(Long id);
}

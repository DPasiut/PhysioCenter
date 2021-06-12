package com.example.PhysioCenter.service.serviceImpl;

import com.example.PhysioCenter.domain.dto.diagnosis.DiagnosisDto;
import com.example.PhysioCenter.domain.entity.Diagnosis;
import com.example.PhysioCenter.domain.entity.DiagnosisExercises;
import com.example.PhysioCenter.domain.repository.DiagnosisExercisesRepository;
import com.example.PhysioCenter.domain.repository.DiagnosisRepository;
import com.example.PhysioCenter.service.DiagnosisService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {

    private final DiagnosisRepository diagnosisRepository;
    private final DiagnosisExercisesRepository diagnosisExercisesRepository;

    public DiagnosisServiceImpl(DiagnosisRepository diagnosisRepository, DiagnosisExercisesRepository diagnosisExercisesRepository) {
        this.diagnosisRepository = diagnosisRepository;
        this.diagnosisExercisesRepository = diagnosisExercisesRepository;
    }

    @Override
    public List<DiagnosisDto> getAllByPatientId(Long id) {
        return StreamSupport.stream(diagnosisRepository
                .findAll().spliterator(), false)
                .filter(diagnosis -> diagnosis.getPatientId().equals(id))
                .map(Diagnosis::dto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Long> getAllExercisesByDiagnosisId(Long id) {
        List<Long> exercisesIds = new ArrayList<>();

        List<DiagnosisExercises> diagnosisExercise = StreamSupport.stream(diagnosisExercisesRepository
                .findAll().spliterator(), false)
                .filter(diagnosis -> diagnosis.getDiagnosisId().equals(id))
                .collect(Collectors.toList());

        for (DiagnosisExercises exercise: diagnosisExercise){
            exercisesIds.add(exercise.getExerciseId());
        }

        return exercisesIds;
    }

}

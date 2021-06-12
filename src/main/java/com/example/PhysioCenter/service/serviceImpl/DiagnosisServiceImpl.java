package com.example.PhysioCenter.service.serviceImpl;

import com.example.PhysioCenter.controller.PatientApiController;
import com.example.PhysioCenter.domain.dto.diagnosis.AddDiagnosisDto;
import com.example.PhysioCenter.domain.dto.diagnosis.AddDiagnosisExercisesDto;
import com.example.PhysioCenter.domain.dto.diagnosis.DiagnosisDto;
import com.example.PhysioCenter.domain.dto.exercise.ExerciseDto;
import com.example.PhysioCenter.domain.entity.Diagnosis;
import com.example.PhysioCenter.domain.entity.DiagnosisExercises;
import com.example.PhysioCenter.domain.entity.Exercise;
import com.example.PhysioCenter.domain.repository.DiagnosisExercisesRepository;
import com.example.PhysioCenter.domain.repository.DiagnosisRepository;
import com.example.PhysioCenter.domain.repository.ExerciseRepository;
import com.example.PhysioCenter.service.DiagnosisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiagnosisServiceImpl.class);


    private final DiagnosisRepository diagnosisRepository;
    private final DiagnosisExercisesRepository diagnosisExercisesRepository;
    private final ExerciseRepository exerciseRepository;

    public DiagnosisServiceImpl(DiagnosisRepository diagnosisRepository, DiagnosisExercisesRepository diagnosisExercisesRepository, ExerciseRepository exerciseRepository) {
        this.diagnosisRepository = diagnosisRepository;
        this.diagnosisExercisesRepository = diagnosisExercisesRepository;
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public List<DiagnosisDto> getAllByPatientId(Long id) {

        return StreamSupport.stream(diagnosisRepository
                .findAll(Sort.by(Sort.Direction.DESC, "diagnosisDate")).spliterator(), false)
                .filter(diagnosis -> diagnosis.getPatientId().equals(id))
                .map(Diagnosis::dto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseDto> getAllExercisesByDiagnosisId(Long id) {
        List<Long> exercisesIds = new ArrayList<>();

        List<DiagnosisExercises> diagnosisExercise =
                StreamSupport.stream(diagnosisExercisesRepository
                .findAll().spliterator(), false)
                .filter(diagnosis -> diagnosis.getDiagnosisId().equals(id))
                .collect(Collectors.toList());

        for (DiagnosisExercises exercise: diagnosisExercise){
            exercisesIds.add(exercise.getExerciseId());
        }

        return StreamSupport.stream(exerciseRepository
                .findAll().spliterator(), false)
                .filter(exercise -> exercisesIds.stream()
                        .anyMatch(aLong -> aLong.equals(exercise.getExerciseId())))
                .map(Exercise::dto)
                .collect(Collectors.toList());
    }

    @Override
    public DiagnosisDto addDiagnosis(AddDiagnosisDto addDiagnosisDto) {

        Diagnosis diag = Diagnosis.builder()
                .diagnosis(addDiagnosisDto.getDiagnosis())
                .patientId(addDiagnosisDto.getPatientId())
                .physioId(addDiagnosisDto.getPhysioId())
                .diagnosisDate(LocalDateTime.now())
                .build();

        try {
            diagnosisRepository.save(diag);
        }catch (Exception e){
            LOGGER.info("Something went wrong while save new Diagnosis");
        }

        return diag.dto();
    }

    @Override
    public AddDiagnosisExercisesDto addDiagnosisExercises(AddDiagnosisExercisesDto addDiagnosisExercisesDto) {

        DiagnosisExercises diagnosisExercises = DiagnosisExercises.builder()
                .diagnosisId(addDiagnosisExercisesDto.getDiagnosisId())
                .exerciseId(addDiagnosisExercisesDto.getExerciseId())
                .build();

        try {
            diagnosisExercisesRepository.save(diagnosisExercises);
        }catch (Exception e){
            LOGGER.info("Something went wrong while saving new diagnosis_exercises");
        }

        return diagnosisExercises.dto();
    }



    @Override
    public List<ExerciseDto> getAllExercises() {
        return StreamSupport.stream(exerciseRepository
                .findAll().spliterator(), false)
                .map(Exercise::dto)
                .collect(Collectors.toList());
    }
}

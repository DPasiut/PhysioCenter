package com.example.PhysioCenter.controller;

import com.example.PhysioCenter.domain.dto.diagnosis.DiagnosisDto;
import com.example.PhysioCenter.domain.dto.exercise.ExerciseDto;
import com.example.PhysioCenter.domain.dto.visit.VisitDto;
import com.example.PhysioCenter.domain.entity.Diagnosis;
import com.example.PhysioCenter.service.serviceImpl.DiagnosisServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@Controller
@RequestMapping(value = "/api")
public class DiagnosisController {

    private final DiagnosisServiceImpl diagnosisService;

    public DiagnosisController(DiagnosisServiceImpl diagnosisService) {
        this.diagnosisService = diagnosisService;
    }

    @CrossOrigin
    @GetMapping(value = "/diagnosis/{id}")
    public ResponseEntity<List<DiagnosisDto>> getDiagnosisByPatientId(@PathVariable Long id) {
        LOGGER.info("find diagnosis by patient id");

        List<DiagnosisDto> diagnosisDto = diagnosisService.getAllByPatientId(id);
        return new ResponseEntity<>(diagnosisDto, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/diagnosis/exercises/{id}")
    public ResponseEntity<List<ExerciseDto>> getExercisesIdsByDiagnosisId(@PathVariable Long id){
        LOGGER.info("get exercises ids by diagnosis id");

        List<ExerciseDto> exercisesIds = diagnosisService.getAllExercisesByDiagnosisId(id);
        return new ResponseEntity<>(exercisesIds, HttpStatus.OK);
    }
}

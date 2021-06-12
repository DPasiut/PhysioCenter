package com.example.PhysioCenter.domain.repository;

import com.example.PhysioCenter.domain.entity.DiagnosisExercises;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosisExercisesRepository extends CrudRepository<DiagnosisExercises, Long> {
}

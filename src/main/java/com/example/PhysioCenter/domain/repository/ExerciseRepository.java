package com.example.PhysioCenter.domain.repository;

import com.example.PhysioCenter.domain.entity.Exercise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
}

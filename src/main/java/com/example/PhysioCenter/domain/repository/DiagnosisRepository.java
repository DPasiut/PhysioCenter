package com.example.PhysioCenter.domain.repository;

import com.example.PhysioCenter.domain.entity.Diagnosis;
import org.springframework.data.repository.CrudRepository;

public interface DiagnosisRepository extends CrudRepository<Diagnosis, Long> {
}

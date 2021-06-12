package com.example.PhysioCenter.domain.repository;

import com.example.PhysioCenter.domain.dto.diagnosis.DiagnosisDto;
import com.example.PhysioCenter.domain.entity.Diagnosis;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DiagnosisRepository extends CrudRepository<Diagnosis, Long> {
    List<Diagnosis>  findAll(Sort diagnosisDate);
}

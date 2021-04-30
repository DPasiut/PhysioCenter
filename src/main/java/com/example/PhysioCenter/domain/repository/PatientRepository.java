package com.example.PhysioCenter.domain.repository;

import com.example.PhysioCenter.domain.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PatientRepository extends
        JpaRepository<Patient, Long>,
        CrudRepository<Patient, Long> {
}

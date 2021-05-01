package com.example.PhysioCenter.domain.repository;

import com.example.PhysioCenter.domain.dto.patient.PatientDto;
import com.example.PhysioCenter.domain.dto.patient.PatientNotFoundException;
import com.example.PhysioCenter.domain.entity.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

    default PatientDto findOneOrThrown(Long id){
        Optional<Patient> patient = findById(id);
        if (patient.isPresent()){
            return patient.get().dto();
        }
        throw new PatientNotFoundException();
    }
}

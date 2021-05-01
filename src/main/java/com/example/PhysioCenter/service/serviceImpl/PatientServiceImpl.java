package com.example.PhysioCenter.service.serviceImpl;

import com.example.PhysioCenter.domain.dto.patient.PatientDto;
import com.example.PhysioCenter.domain.dto.patient.PatientNotFoundException;
import com.example.PhysioCenter.domain.entity.Patient;
import com.example.PhysioCenter.domain.repository.PatientRepository;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.PhysioCenter.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.util.Objects.requireNonNull;

@Service
public class PatientServiceImpl implements PatientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatientServiceImpl.class);

    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<PatientDto> findAll() {
        return StreamSupport.stream(patientRepository
                .findAll().spliterator(), false)
                .map(Patient::dto)
                .collect(Collectors.toList());
    }

    @Override
    public PatientDto getPatientById(Long id){
        requireNonNull(id);
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent()){
            return patient.get().dto();
        }
        throw new PatientNotFoundException(id);
    }

    @Override
    public void updatePatient(PatientDto patient) {

    }

    @Override
    public void deletePatientById(Long Id) {

    }

}

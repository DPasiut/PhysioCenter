package com.example.PhysioCenter.service.serviceImpl;

import com.example.PhysioCenter.domain.dto.patient.PatientDto;
import com.example.PhysioCenter.domain.dto.patient.PatientNotFoundException;
import com.example.PhysioCenter.domain.entity.Patient;
import com.example.PhysioCenter.domain.repository.PatientRepository;
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
        return findPatientById(id).get().dto();
    }

    @Override
    public void updatePatient(PatientDto patientDto, Long id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);

        if(patientOptional.isPresent()){
            Patient patient = patientOptional.get();

            patientRepository.save(patient.toBuilder()
                    .name(patientDto.getName())
                    .email(patientDto.getEmail())
                    .peselNo(patientDto.getPeselNo())
                    .phoneNumber(patientDto.getPhoneNumber())
                    .surname(patientDto.getSurname())
                    .build());

        }
    }

    @Override
    public boolean deletePatientById(Long id) {
        try {
            patientRepository.deleteById(id);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }

    private Optional<Patient> findPatientById(Long id){
        Optional<Patient> patient = patientRepository.findById(id);
        if(patient.isPresent()){
            return patient;
        }
        throw new PatientNotFoundException(id);
    }
}

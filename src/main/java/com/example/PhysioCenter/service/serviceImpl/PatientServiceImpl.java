package com.example.PhysioCenter.service.serviceImpl;

import com.example.PhysioCenter.domain.dto.PatientDto;
import com.example.PhysioCenter.domain.entity.Patient;
import com.example.PhysioCenter.domain.mapper.Converter;
import com.example.PhysioCenter.domain.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.PhysioCenter.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatientServiceImpl.class);

    private final PatientRepository patientRepository;
    private final Converter<List<PatientDto>, List<Patient>> patientListMapper;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository,
                              Converter<List<PatientDto>, List<Patient>> patientListMapper) {
        this.patientRepository = patientRepository;
        this.patientListMapper = patientListMapper;
    }


    @Override
    public List<PatientDto> findAll() {
        List<Patient> patients = patientRepository.findAll();
        return patientListMapper.convert(patients);

    }
}

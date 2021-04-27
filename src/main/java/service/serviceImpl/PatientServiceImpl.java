package service.serviceImpl;

import domain.dto.PatientDto;
import domain.entity.Patient;
import domain.mapper.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import repository.PatientRepository;
import service.PatientService;

import java.util.List;

public class PatientServiceImpl implements PatientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatientServiceImpl.class);

    @Autowired
    private final PatientRepository patientRepository;
    private final Converter<List<PatientDto>, List<Patient>> patientListMapper;

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

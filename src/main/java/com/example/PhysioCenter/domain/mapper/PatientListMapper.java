package com.example.PhysioCenter.domain.mapper;

import com.example.PhysioCenter.domain.dto.PatientDto;
import com.example.PhysioCenter.domain.entity.Patient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientListMapper implements  Converter<List<PatientDto>, List<Patient>> {


    @Override
    public List<PatientDto> convert(List<Patient> patients) {
        List<PatientDto> patientDto;

        patientDto = patients.stream()
                .map(patient -> new PatientDto.Builder()
                        .patientId(patient.getPatientId())
                        .name(patient.getName())
                        .secondName(patient.getSecondName())
                        .email(patient.getEmail())
                        .peselNo(patient.getPeselNo())
                        .phoneNumber(patient.getPhoneNumber())
                        .build()).collect(Collectors.toList());

        return patientDto;
    }
}

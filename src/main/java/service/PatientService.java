package service;

import domain.dto.PatientDto;

import java.util.List;

public interface PatientService {

    List<PatientDto> findAll();
}

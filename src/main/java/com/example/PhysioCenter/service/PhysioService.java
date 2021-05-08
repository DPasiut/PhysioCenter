package com.example.PhysioCenter.service;

import com.example.PhysioCenter.domain.dto.physioteraphist.PhysioDto;
import com.example.PhysioCenter.domain.entity.Physio;
import com.example.PhysioCenter.domain.exceptions.PhysioNotCreatedException;

import java.util.List;

public interface PhysioService {
    List<PhysioDto> findAll();
    PhysioDto getPhysioById(Long id);
    PhysioDto updatePhysio(PhysioDto patient, Long id);
    boolean deletePhysioById(Long id);
    PhysioDto addPhysio(PhysioDto physioDto) throws PhysioNotCreatedException;
}

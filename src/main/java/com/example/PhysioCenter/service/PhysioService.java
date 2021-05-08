package com.example.PhysioCenter.service;

import com.example.PhysioCenter.domain.dto.physioteraphist.PhysioDto;
import com.example.PhysioCenter.domain.entity.Physio;

import java.util.List;

public interface PhysioService {
    List<PhysioDto> findAll();
    PhysioDto getPhysioById(Long id);
    void updatePhysio(PhysioDto patient, Long id);
    boolean deletePhysioById(Long id);
    Physio addPhysio(Physio patient);
}

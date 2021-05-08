package com.example.PhysioCenter.service.serviceImpl;

import com.example.PhysioCenter.domain.dto.physioteraphist.PhysioDto;
import com.example.PhysioCenter.domain.entity.Physio;
import com.example.PhysioCenter.domain.exceptions.PhysioNotFoundException;
import com.example.PhysioCenter.domain.repository.PhysioRepository;
import com.example.PhysioCenter.service.PhysioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PhysioServiceImpl implements PhysioService {

    private final PhysioRepository physioRepository;

    public PhysioServiceImpl(PhysioRepository physioRepository) {
        this.physioRepository = physioRepository;
    }

    @Override
    public List<PhysioDto> findAll() {
        return StreamSupport.stream(physioRepository
                .findAll().spliterator(), false)
                .map(Physio::dto)
                .collect(Collectors.toList());
    }

    @Override
    public PhysioDto getPhysioById(Long id) {
        Optional<Physio> physio = physioRepository.findById(id);
        if (physio.isPresent()){
            return physio.get().dto();
        }
        throw new PhysioNotFoundException(id);
    }

    @Override
    public void updatePhysio(PhysioDto patient, Long id) {

    }

    @Override
    public boolean deletePhysioById(Long id) {
        return false;
    }

    @Override
    public Physio addPhysio(Physio patient) {
        return null;
    }
}

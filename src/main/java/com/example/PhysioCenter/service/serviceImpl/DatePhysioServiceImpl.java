package com.example.PhysioCenter.service.serviceImpl;

import com.example.PhysioCenter.domain.dto.datePhysio.DatePhysioDto;
import com.example.PhysioCenter.domain.entity.DateOfTheVisit;
import com.example.PhysioCenter.domain.entity.DatePhysio;
import com.example.PhysioCenter.domain.repository.DatePhysioRepository;
import com.example.PhysioCenter.service.DatePhysioService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DatePhysioServiceImpl implements DatePhysioService {

    private final DatePhysioRepository datePhysioRepository;

    public DatePhysioServiceImpl(DatePhysioRepository datePhysioRepository) {
        this.datePhysioRepository = datePhysioRepository;
    }

    @Override
    public List<DatePhysioDto> getAll() {
        return datePhysioRepository
                .findAllDatePhysio().stream()
                .map(DatePhysio::dto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DatePhysioDto> getByPhysioId(Long id) {
        return StreamSupport.stream(datePhysioRepository
                .findAll().spliterator(), false)
                .filter(datePhysio -> datePhysio.getPhysioId().equals(id))
                .map(DatePhysio::dto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DatePhysioDto> getAvailableDatesByPhysioId(Long id) {
        return StreamSupport.stream(datePhysioRepository
                .findAll().spliterator(), false)
                .filter(datePhysio -> datePhysio.getPhysioId().equals(id)
                && datePhysio.getIsAvailable())
                .map(DatePhysio::dto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DatePhysioDto> getAllAvailableDatesPhysio() {
        return StreamSupport.stream(datePhysioRepository
                .findAll().spliterator(), false)
                .filter(DatePhysio::getIsAvailable)
                .map(DatePhysio::dto)
                .collect(Collectors.toList());
    }
}

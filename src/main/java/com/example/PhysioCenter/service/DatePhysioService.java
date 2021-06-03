package com.example.PhysioCenter.service;

import com.example.PhysioCenter.domain.dto.datePhysio.DatePhysioDto;
import java.util.List;

public interface DatePhysioService {
    List<DatePhysioDto> getAll();
    List<DatePhysioDto> getByPhysioId(Long id);
    List<DatePhysioDto> getAvailableDatesByPhysioId(Long id);
    List<DatePhysioDto> getAllAvailableDatesPhysio();
}

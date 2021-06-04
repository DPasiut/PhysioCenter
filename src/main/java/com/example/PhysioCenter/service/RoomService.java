package com.example.PhysioCenter.service;

import com.example.PhysioCenter.domain.dto.visit.VisitRoomDto;

public interface RoomService {
    VisitRoomDto getRoomById(Long id);
}

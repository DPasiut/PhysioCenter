package com.example.PhysioCenter.service;

import com.example.PhysioCenter.domain.dto.dateRoom.AddDateRoomDto;
import com.example.PhysioCenter.domain.dto.dateRoom.DateRoomDto;

import java.util.List;

public interface DateRoomService {
    List<DateRoomDto> getAll();
    List<DateRoomDto> getByRoomId(Long id);
    List<DateRoomDto> getAvailableDatesByRoomId(Long id);
    List<DateRoomDto> getAllAvailableDatesRooms();
    DateRoomDto addDateRoom(AddDateRoomDto addDateRoomDto);
}

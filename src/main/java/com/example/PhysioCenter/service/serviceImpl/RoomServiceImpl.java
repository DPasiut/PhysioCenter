package com.example.PhysioCenter.service.serviceImpl;

import com.example.PhysioCenter.domain.dto.visit.VisitRoomDto;
import com.example.PhysioCenter.domain.entity.Room;
import com.example.PhysioCenter.domain.repository.RoomRepository;
import com.example.PhysioCenter.service.RoomService;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }


    @Override
    public VisitRoomDto getRoomById(Long id) {
        Room room = roomRepository.findById(id).get();
        return new VisitRoomDto(room.getRoomNumber());
    }
}

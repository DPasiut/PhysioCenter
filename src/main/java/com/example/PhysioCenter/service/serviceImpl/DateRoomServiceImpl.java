package com.example.PhysioCenter.service.serviceImpl;

import com.example.PhysioCenter.domain.dto.dateRoom.AddDateRoomDto;
import com.example.PhysioCenter.domain.dto.dateRoom.DateRoomDto;
import com.example.PhysioCenter.domain.entity.DateRoom;
import com.example.PhysioCenter.domain.repository.DateRoomRepository;
import com.example.PhysioCenter.service.DateRoomService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DateRoomServiceImpl implements DateRoomService {

    private final DateRoomRepository dateRoomRepository;

    public DateRoomServiceImpl(DateRoomRepository dateRoomRepository) {
        this.dateRoomRepository = dateRoomRepository;
    }

    @Override
    public List<DateRoomDto> getAll() {
        return null;
    }

    @Override
    public List<DateRoomDto> getByRoomId(Long id) {
        return StreamSupport.stream(dateRoomRepository
                .findAll().spliterator(), false)
                .filter(dateRoom -> dateRoom.getRoomId().equals(id))
                .map(DateRoom::dto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DateRoomDto> getAvailableDatesByRoomId(Long id) {
        return StreamSupport.stream(dateRoomRepository
                .findAll().spliterator(), false)
                .filter(dateRoom -> dateRoom.getRoomId().equals(id)
                && dateRoom.getIsAvailable())
                .map(DateRoom::dto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DateRoomDto> getAllAvailableDatesRooms() {
        return StreamSupport.stream(dateRoomRepository
                .findAll().spliterator(), false)
                .filter(DateRoom::getIsAvailable)
                .map(DateRoom::dto)
                .collect(Collectors.toList());
    }

    @Override
    public DateRoomDto addDateRoom(AddDateRoomDto addDateRoomDto) {
        DateRoom dateRoom = new DateRoom();
        dateRoom.setDateId(addDateRoomDto.getDateId());
        dateRoom.setRoomId(addDateRoomDto.getRoomId());
        dateRoom.setIsAvailable(true);
        //TODO refactor to builder

        dateRoomRepository.save(dateRoom);

        return dateRoom.dto();
    }
}

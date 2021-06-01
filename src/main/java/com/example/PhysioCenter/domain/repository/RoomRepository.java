package com.example.PhysioCenter.domain.repository;

import com.example.PhysioCenter.domain.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
}

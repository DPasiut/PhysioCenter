package com.example.PhysioCenter.domain.repository;

import com.example.PhysioCenter.domain.entity.DateRoom;
import com.example.PhysioCenter.domain.entity.DateRoomId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateRoomRepository extends CrudRepository<DateRoom, DateRoomId> {
}

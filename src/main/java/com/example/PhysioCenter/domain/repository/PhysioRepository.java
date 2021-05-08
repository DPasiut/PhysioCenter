package com.example.PhysioCenter.domain.repository;

import com.example.PhysioCenter.domain.entity.Physio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysioRepository extends CrudRepository<Physio, Long> {
}

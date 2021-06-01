package com.example.PhysioCenter.domain.repository;

import com.example.PhysioCenter.domain.entity.Visit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends CrudRepository<Visit, String> {
}

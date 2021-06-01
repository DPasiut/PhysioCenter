package com.example.PhysioCenter.domain.repository;

import com.example.PhysioCenter.domain.entity.DateOfTheVisit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateOfTheVisitRepository extends CrudRepository<DateOfTheVisit, Long> {
}

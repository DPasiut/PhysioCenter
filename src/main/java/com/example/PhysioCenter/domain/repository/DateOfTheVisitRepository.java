package com.example.PhysioCenter.domain.repository;

import com.example.PhysioCenter.domain.entity.DateOfTheVisit;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DateOfTheVisitRepository extends CrudRepository<DateOfTheVisit, Long> {
    List<DateOfTheVisit> findAll(Sort date);
}

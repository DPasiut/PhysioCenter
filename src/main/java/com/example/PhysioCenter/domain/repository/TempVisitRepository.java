package com.example.PhysioCenter.domain.repository;

import com.example.PhysioCenter.domain.entity.TempVisit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TempVisitRepository extends CrudRepository<TempVisit, Long> {
    @Query(value = "SELECT * FROM fizjoterapia.temp_termin AS t WHERE t.id_fizjoterapeuty = :physioId AND t.data = :date", nativeQuery = true)
    List<TempVisit> getVisitsToPhysioByDate(@Param("physioId") Long physioId, @Param("date") LocalDate date);

}

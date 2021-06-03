package com.example.PhysioCenter.domain.repository;

import com.example.PhysioCenter.domain.entity.DatePhysio;
import com.example.PhysioCenter.domain.entity.DatePhysioId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatePhysioRepository extends CrudRepository <DatePhysio, DatePhysioId>{

    @Query(value = "SELECT * FROM fizjoterapia.fizjoterapeuta_termin limit 10", nativeQuery = true)
    List<DatePhysio> findAllDatePhysio();

}

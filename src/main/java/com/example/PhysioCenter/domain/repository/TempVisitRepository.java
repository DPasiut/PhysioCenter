package com.example.PhysioCenter.domain.repository;

import com.example.PhysioCenter.domain.entity.TempVisit;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface TempVisitRepository extends CrudRepository<TempVisit, Long> {
    @Query(value = "SELECT * FROM fizjoterapia.temp_termin AS t WHERE t.id_fizjoterapeuty = :physioId " +
            "AND t.data = :date", nativeQuery = true)
    List<TempVisit> getVisitsToPhysioByDate(@Param("physioId") Long physioId, @Param("date") LocalDate date);

    @Query(value = "SELECT * FROM fizjoterapia.temp_termin AS t WHERE t.id_fizjoterapeuty = :physioId " +
            "AND t.data = :date AND t.czas_od = :timeFrom AND t.czas_do = :timeTo", nativeQuery = true)
    TempVisit getVisit(@Param("physioId") Long physioId, @Param("date") LocalDate date, @Param("timeFrom") Time timeFrom, @Param("timeTo") Time timeTo);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "INSERT INTO fizjoterapia.temp_termin (id_fizjoterapeuty, id_pacjenta, wolny, data, czas_od, czas_do)" +
            " VALUES (:physioId, :patientId, false, :date, :timeFrom, :timeTo);", nativeQuery = true)
    Integer registerVisit(@Param("physioId") Long physioId, @Param("patientId") Long patientId, @Param("date") LocalDate date, @Param("timeFrom") Time timeFrom, @Param("timeTo") Time timeTo);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE fizjoterapia.temp_termin AS t SET wolny = true, id_pacjenta = null WHERE t.id_fizjoterapeuty = :physioId " +
            "AND t.data = :date AND t.czas_od = :timeFrom AND t.czas_do = :timeTo", nativeQuery = true)
    Integer cancelVisit(@Param("physioId") Long physioId, @Param("date") LocalDate date, @Param("timeFrom") Time timeFrom, @Param("timeTo") Time timeTo);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE fizjoterapia.temp_termin AS t SET wolny = false, id_pacjenta = :patientId WHERE t.id_fizjoterapeuty = :physioId " +
            "AND t.data = :date AND t.czas_od = :timeFrom AND t.czas_do = :timeTo", nativeQuery = true)
    Integer registerExistingVisit(@Param("physioId") Long physioId, @Param("patientId") Long patientId, @Param("date") LocalDate date, @Param("timeFrom") Time timeFrom, @Param("timeTo") Time timeTo);

}

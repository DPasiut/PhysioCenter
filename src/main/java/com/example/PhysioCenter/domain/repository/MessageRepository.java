package com.example.PhysioCenter.domain.repository;

import com.example.PhysioCenter.domain.entity.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
    @Query(value = "SELECT * FROM fizjoterapia.wiadomosci AS m WHERE m.fizjo_id = :physioId AND m.pacjent_id = :patientId ORDER BY m.date LIMIT 1", nativeQuery = true)
    Message getLastMessage(@Param("patientId") Long patientId, @Param("physioId") Long physioId);

    @Query(value = "SELECT DISTINCT(m.pacjent_id) FROM fizjoterapia.wiadomosci AS m WHERE m.fizjo_id = :physioId", nativeQuery = true)
    List<Long> getPatientMessageIds(@Param("physioId") Long physioId);

    @Query(value = "SELECT DISTINCT(m.fizjo_id) FROM fizjoterapia.wiadomosci AS m WHERE m.pacjent_id = :patientId", nativeQuery = true)
    List<Long> getPhysioMessageIds(@Param("patientId") Long patientId);

    @Query(value = "SELECT * FROM fizjoterapia.wiadomosci AS m WHERE m.pacjent_id = :patientId AND m.fizjo_id = :physioId", nativeQuery = true)
    List<Message> getMessageWithPerson(@Param("physioId") Long physioId, @Param("patientId") Long patientId);
}

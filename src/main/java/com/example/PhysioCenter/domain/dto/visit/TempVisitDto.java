package com.example.PhysioCenter.domain.dto.visit;

import lombok.*;

import javax.persistence.Column;
import java.sql.Time;
import java.util.Date;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class TempVisitDto {
    private Long visitId;
    private Long physioId;
    private Long patientId;
    private Boolean occupied;
    private Date date;
    private Time czas_od;
    private Time czas_do;
}

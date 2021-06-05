package com.example.PhysioCenter.domain.dto.visit;

import lombok.*;

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
    private Boolean free;
    private Date date;
    private String timeFrom;
    private String timeTo;
}

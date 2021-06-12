package com.example.PhysioCenter.domain.dto.diagnosis;

import lombok.*;

import java.util.Date;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

public class DiagnosisDto {
    Long diagnosisId;
    String diagnosisDate;
    String diagnosisHour;
    Long patientId;
    Long physioId;
    String diagnosis;
}

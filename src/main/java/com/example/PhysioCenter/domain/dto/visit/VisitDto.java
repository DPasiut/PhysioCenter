package com.example.PhysioCenter.domain.dto.visit;

import lombok.*;

import java.util.Date;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class VisitDto {
    String patientName;
    String patientSurname;
    String physioName;
    String physioSurname;
    Long roomNumber;
    Date date;
}



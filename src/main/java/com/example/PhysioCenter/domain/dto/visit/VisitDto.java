package com.example.PhysioCenter.domain.dto.visit;

import lombok.*;


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
    String roomNumber;
    String date;
    String hourFrom;
    String hourTo;
}



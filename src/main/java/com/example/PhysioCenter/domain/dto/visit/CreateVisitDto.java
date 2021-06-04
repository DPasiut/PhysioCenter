package com.example.PhysioCenter.domain.dto.visit;

import lombok.*;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class CreateVisitDto {
    Long patientId;
    Long physioId;
    Long roomId;
    Long dateId;
}

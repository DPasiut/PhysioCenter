package com.example.PhysioCenter.domain.dto.visit;

import lombok.*;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AvailableVisitDto {
    private String timeFrom;
    private String timeTo;
    private String date;
    private Long physioId;
    private boolean isOccupied;
}

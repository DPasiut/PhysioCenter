package com.example.PhysioCenter.domain.dto.visit;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AddDateDto {
    LocalDate date;
    LocalTime startHour;
    LocalTime endHour;
}

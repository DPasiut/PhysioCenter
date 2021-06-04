package com.example.PhysioCenter.domain.dto.visit;

import lombok.*;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class DateOfTheVisitDto {
    private Long id;
    private String lowerBound;
    private String upperBound;
    //private LocalDate date;
}

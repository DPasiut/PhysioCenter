package com.example.PhysioCenter.domain.dto.visit;

import com.vladmihalcea.hibernate.type.range.Range;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


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

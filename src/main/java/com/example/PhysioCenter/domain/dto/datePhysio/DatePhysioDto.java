package com.example.PhysioCenter.domain.dto.datePhysio;

import lombok.*;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class DatePhysioDto {
    private Long physioId;
    private Long dateId;
    private Boolean isAvailable;
}

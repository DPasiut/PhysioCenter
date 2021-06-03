package com.example.PhysioCenter.domain.dto.datePhysio;

import lombok.*;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

public class AddDatePhysioDto {
    private Long physioId;
    private Long dateId;
}

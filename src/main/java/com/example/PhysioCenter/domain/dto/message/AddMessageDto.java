package com.example.PhysioCenter.domain.dto.message;

import lombok.*;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AddMessageDto {
    private Long patientId;
    private Long physioId;
    private Boolean directionToPhysio;
    private String message;
}

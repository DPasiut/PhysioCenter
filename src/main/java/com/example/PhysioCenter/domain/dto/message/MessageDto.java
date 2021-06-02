package com.example.PhysioCenter.domain.dto.message;

import lombok.*;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class MessageDto {
    private Long messageId;
    private Long patientId;
    private Long physioId;
    private Boolean directionToPhysio;
    private String message;
}

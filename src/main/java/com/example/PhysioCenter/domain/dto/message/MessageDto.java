package com.example.PhysioCenter.domain.dto.message;

import lombok.*;

import java.util.Date;

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
    private Date date;
}

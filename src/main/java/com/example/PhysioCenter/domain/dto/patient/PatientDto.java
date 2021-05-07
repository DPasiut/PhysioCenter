package com.example.PhysioCenter.domain.dto.patient;

import lombok.*;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString


public class PatientDto {
    private Long patientId;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String peselNo;
}

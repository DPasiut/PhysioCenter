package com.example.PhysioCenter.domain.dto;

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
    private String secondName;
    private String phoneNumber;
    private String email;
    private String peselNo;
}

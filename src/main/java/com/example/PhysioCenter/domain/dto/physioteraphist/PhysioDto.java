package com.example.PhysioCenter.domain.dto.physioteraphist;

import lombok.*;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PhysioDto {
    private Long physioId;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String licenceNo;
}

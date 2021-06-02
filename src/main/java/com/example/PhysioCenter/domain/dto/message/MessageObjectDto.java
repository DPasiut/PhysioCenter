package com.example.PhysioCenter.domain.dto.message;

import com.example.PhysioCenter.domain.dto.patient.PatientDto;
import com.example.PhysioCenter.domain.dto.physioteraphist.PhysioDto;
import lombok.*;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class MessageObjectDto {
    MessageDto message;
    PatientDto patient;
    PhysioDto physio;
}

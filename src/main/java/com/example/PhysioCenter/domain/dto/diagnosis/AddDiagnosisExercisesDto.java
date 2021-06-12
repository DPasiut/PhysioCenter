package com.example.PhysioCenter.domain.dto.diagnosis;

import lombok.*;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString


public class AddDiagnosisExercisesDto {
    Long diagnosisId;
    Long ExerciseId;
}

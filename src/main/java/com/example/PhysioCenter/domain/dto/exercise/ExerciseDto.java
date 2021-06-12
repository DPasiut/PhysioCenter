package com.example.PhysioCenter.domain.dto.exercise;

import lombok.*;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString


public class ExerciseDto {
    Long exerciseId;
    String exerciseName;
    String exerciseDescription;
    String videoUrl;
}

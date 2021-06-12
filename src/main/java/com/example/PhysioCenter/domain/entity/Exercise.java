package com.example.PhysioCenter.domain.entity;

import com.example.PhysioCenter.domain.dto.exercise.ExerciseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "fizjoterapia", name = "cwiczenie")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)

public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_cwiczenia")
    private Long exerciseId;

    @Column(name = "nazwa")
    private String exerciseName;

    @Column(name = "opis")
    private String exerciseDescription;

    public ExerciseDto dto(){
        return ExerciseDto.builder()
                .exerciseId(this.exerciseId)
                .exerciseName(this.exerciseName)
                .exerciseDescription(this.exerciseDescription)
                .build();
    }
}

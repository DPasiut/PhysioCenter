package com.example.PhysioCenter.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(schema = "fizjoterapia", name = "diagnoza_cwiczenia")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)

public class DiagnosisExercises {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_wpisu")
    private Long enterId;

    @Column(name = "id_diagnozy")
    private Long diagnosisId;

    @Column(name = "id_cwiczenia")
    private Long exerciseId;

}

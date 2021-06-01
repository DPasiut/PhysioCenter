package com.example.PhysioCenter.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "fizjoterapia", name = "wizyta")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)

public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "nr_wizyty")
    private String visitId;

    @Column(name = "id_pacjenta")
    private Long patientId;

    @Column(name = "id_fizjoterapeuty")
    private Long physioId;

    @Column(name = "id_gabinetu")
    private Long roomId;

    @Column(name = "id_terminu")
    private Long dateId;
}


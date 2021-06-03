package com.example.PhysioCenter.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "fizjoterapia", name = "fizjoterapeuta_termin")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)

public class DateRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_terminu")
    private Long physioId;

    @Column(name = "id_gabinetu")
    private Long roomId;
}

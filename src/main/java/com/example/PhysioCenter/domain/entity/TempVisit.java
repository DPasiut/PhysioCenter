package com.example.PhysioCenter.domain.entity;


import com.example.PhysioCenter.domain.dto.visit.TempVisitDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(schema = "fizjoterapia", name = "temp_termin")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)

public class TempVisit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_terminu")
    private Long visitId;

    @Column(name = "id_fizjoterapeuty")
    private Long physioId;

    @Column(name = "id_pacjenta")
    private Long patientId;

    @Column(name = "wolny")
    private Boolean occupied;

    @Column(name = "data")
    private Date date;

    @Column(name = "czas_od")
    private Time czas_od;

    @Column(name = "czas_do")
    private Time czas_do;


    public TempVisitDto dto(){
        return TempVisitDto.builder()
                .visitId(this.visitId)
                .physioId(this.physioId)
                .patientId(this.patientId)
                .occupied(this.occupied)
                .date(this.date)
                .czas_od(this.czas_od)
                .czas_do(this.czas_do)
                .build();
    }

}

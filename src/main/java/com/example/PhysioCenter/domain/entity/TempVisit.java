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
    private Boolean free;

    @Column(name = "data")
    private Date date;

    @Column(name = "czas_od")
    private String timeFrom;

    @Column(name = "czas_do")
    private String timeTo;


    public TempVisitDto dto(){
        return TempVisitDto.builder()
                .visitId(this.visitId)
                .physioId(this.physioId)
                .patientId(this.patientId)
                .free(this.free)
                .date(this.date)
                .timeFrom(this.timeFrom)
                .timeTo(this.timeTo)
                .build();
    }

}

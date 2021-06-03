package com.example.PhysioCenter.domain.entity;

import com.example.PhysioCenter.domain.dto.visit.CreateVisitDto;
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
    private Long visitId;

    @Column(name = "id_pacjenta")
    private Long patientId;

    @Column(name = "id_fizjoterapeuty")
    private Long physioId;

    @Column(name = "id_gabinetu")
    private Long roomId;

    @Column(name = "id_terminu")
    private Long dateId;

//    public CreateVisitDto dto(){
//        return CreateVisitDto.builder()
//                .dateId(this.dateId)
//                .patientId(this.patientId)
//                .physioId(this.physioId)
//                .roomId(this.roomId)
//                .build();
//    }
}


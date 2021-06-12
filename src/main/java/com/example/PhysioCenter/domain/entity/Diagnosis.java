package com.example.PhysioCenter.domain.entity;

import com.example.PhysioCenter.domain.dto.diagnosis.DiagnosisDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "fizjoterapia", name = "diagnoza")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)

public class Diagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_diagnozy")
    private Long diagnosisId;

    @Column(name = "data_diagnozy")
    @Temporal(TemporalType.TIMESTAMP)
    private Date diagnosisDate;

    @Column(name = "id_pacjenta")
    private Long patientId;

    @Column(name = "id_fizjoterapeuty")
    private Long physioId;

    @Column(name = "diagnoza")
    private String diagnosis;

    public DiagnosisDto dto(){
        return DiagnosisDto.builder()
                .diagnosisId(this.diagnosisId)
                .diagnosis(this.diagnosis)
                .diagnosisDate(this.diagnosisDate)
                .patientId(this.patientId)
                .physioId(this.physioId)
                .build();
    }
}

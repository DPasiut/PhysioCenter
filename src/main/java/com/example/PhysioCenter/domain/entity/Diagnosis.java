package com.example.PhysioCenter.domain.entity;

import com.example.PhysioCenter.domain.dto.diagnosis.DiagnosisDto;
import com.example.PhysioCenter.domain.dto.diagnosis.ExercisesListDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private LocalDateTime diagnosisDate;

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
                .diagnosisDate(this.diagnosisDate.toLocalDate().toString())
                .diagnosisHour(this.diagnosisDate.toLocalTime().toString())
                .patientId(this.patientId)
                .physioId(this.physioId)
                .build();
    }

}

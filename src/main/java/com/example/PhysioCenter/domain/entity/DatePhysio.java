package com.example.PhysioCenter.domain.entity;


import com.example.PhysioCenter.domain.dto.datePhysio.DatePhysioDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@IdClass(DatePhysioId.class)
@Table(schema = "fizjoterapia", name = "fizjoterapeuta_termin")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)

public class DatePhysio {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)

    @Id
    @Column(name = "id_fizjoterapeuty")
    private Long physioId;

    @Id
    @Column(name = "id_terminu")
    private Long dateId;

    @Column(name = "wolny")
    private Boolean isAvailable;

    public DatePhysioDto dto(){
        return DatePhysioDto.builder()
                .dateId(this.dateId)
                .physioId(this.physioId)
                .isAvailable(this.isAvailable)
                .build();
    }

}

package com.example.PhysioCenter.domain.entity;

import com.example.PhysioCenter.domain.dto.physioteraphist.PhysioDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "fizjoterapia", name = "fizjoterapeuta")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)

public class Physio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_fizjoterapeuty")
    private Long physioId;

    @Column(name = "imie")
    private String name;

    @Column(name = "nazwisko")
    private String surname;

    @Column(name = "telefon")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "nr_uprawnien")
    private String licenceNo;

    public PhysioDto dto() {
        return PhysioDto.builder()
                .physioId(this.physioId)
                .name(this.name)
                .surname(this.surname)
                .phoneNumber(this.phoneNumber.trim())
                .email(this.email)
                .licenceNo(this.licenceNo)
                .build();
    }
}

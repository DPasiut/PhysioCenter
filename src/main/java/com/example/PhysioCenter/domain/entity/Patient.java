package com.example.PhysioCenter.domain.entity;

import com.example.PhysioCenter.domain.dto.patient.PatientDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "fizjoterapia", name = "pacjent")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)

public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //dodać sekwencję w bazie danych do primary key
    @Column(name = "id_pacjenta")
    private Long patientId;

    @Column(name = "imie")
    private String name;

    @Column(name = "nazwisko")
    private String surname;

    @Column(name = "telefon")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "pesel")
    private String peselNo;

    public PatientDto dto(){
        return PatientDto.builder()
                .patientId(this.patientId)
                .name(this.name)
                .surname(this.surname)
                .phoneNumber(this.phoneNumber)
                .email(this.email)
                .peselNo(this.peselNo)
                .build();
    }
}

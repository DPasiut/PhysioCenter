package com.example.PhysioCenter.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "fizjoterapia", name = "pacjent")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Patient implements Serializable {

    @Id
//    @GeneratedValue(generator = "patient_id_sequence", strategy = GenerationType.SEQUENCE)
//    @SequenceGenerator(name = "patient_id_sequence", sequenceName = "patient_id_sequence")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pacjenta")
    private Long patientId;

    @Column(name = "imie")
    private String name;

    @Column(name = "nazwisko")
    private String secondName;

    @Column(name = "telefon")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "pesel")
    private String peselNo;

    private Patient(Builder builder){
        patientId = builder.patientId;
        name = builder.name;
        secondName = builder.secondName;
        email = builder.email;
        phoneNumber = builder.phoneNumber;
        peselNo = builder.peselNo;
    }


    public Long getPatientId() { return patientId; }

    public String getName() { return name; }

    public String getSecondName() { return secondName; }

    public String getPhoneNumber() { return phoneNumber; }

    public String getEmail() { return email; }

    public String getPeselNo() { return peselNo; }

    public static final class Builder{
        private Long patientId;
        private String name;
        private String secondName;
        private String phoneNumber;
        private String email;
        private String peselNo;

        public Builder(){
        }

        public Builder patientId(Long patientId){
            this.patientId = patientId;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder secondName(String secondName){
            this.secondName = secondName;
            return this;
        }

        public Builder phoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder peselNo(String peselNo){
            this.peselNo = peselNo;
            return this;
        }

        public Patient build(){return new Patient(this);}
    }
}

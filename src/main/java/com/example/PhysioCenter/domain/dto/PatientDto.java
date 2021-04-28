package com.example.PhysioCenter.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor

public class PatientDto implements Serializable {

    private Long patientId;
    private String name;
    private String secondName;
    private String phoneNumber;
    private String email;
    private String peselNo;

    private PatientDto(Builder builder){
        patientId = builder.patientId;
        name = builder.name;
        secondName = builder.secondName;
        email = builder.email;
        phoneNumber = builder.phoneNumber;
        peselNo = builder.peselNo;
    }

    public PatientDto(){
    }

    public Long getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPeselNo() {
        return peselNo;
    }

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

        public PatientDto build(){return new PatientDto(this);}
    }
}

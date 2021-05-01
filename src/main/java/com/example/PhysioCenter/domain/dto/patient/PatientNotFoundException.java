package com.example.PhysioCenter.domain.dto.patient;

public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException() {
        //super("No patient of id " + id + " found", null, false, false);
    }
}

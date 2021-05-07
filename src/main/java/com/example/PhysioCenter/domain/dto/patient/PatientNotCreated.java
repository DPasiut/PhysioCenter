package com.example.PhysioCenter.domain.dto.patient;

public class PatientNotCreated extends Exception {
    public PatientNotCreated() {
        super("Failed to create a new Patient");
    }
}
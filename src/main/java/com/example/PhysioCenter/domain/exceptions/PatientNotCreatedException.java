package com.example.PhysioCenter.domain.exceptions;

public class PatientNotCreatedException extends Exception {
    public PatientNotCreatedException() {
        super("Failed to create a new Patient");
    }
}
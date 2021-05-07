package com.example.PhysioCenter.domain.exceptions;

public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException(Long id) {
        super("No patient of id " + id + " found", null, false, false);
    }
}

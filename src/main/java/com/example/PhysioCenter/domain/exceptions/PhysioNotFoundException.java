package com.example.PhysioCenter.domain.exceptions;

public class PhysioNotFoundException extends RuntimeException {
    public PhysioNotFoundException(Long id) {
        super("No physio of id " + id + " found", null, false, false);
    }
}

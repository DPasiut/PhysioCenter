package com.example.PhysioCenter.domain.exceptions;

public class PhysioNotCreatedException extends Exception {
    public PhysioNotCreatedException() {
        super("Failed to create a new Physio");
    }
}

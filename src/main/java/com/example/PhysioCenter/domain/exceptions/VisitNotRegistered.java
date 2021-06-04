package com.example.PhysioCenter.domain.exceptions;

public class VisitNotRegistered extends RuntimeException {
    public VisitNotRegistered(Long id) {
        super("Visit to physio " + id + " failed registration", null, false, false);
    }
}

package com.example.PhysioCenter.domain.exceptions;

public class AuthDataDuplicatedException extends Exception {
    public AuthDataDuplicatedException() {
        super("AuthData duplicated");
    }
}
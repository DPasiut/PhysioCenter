package com.example.PhysioCenter.domain.exceptions;

public class LoginDuplicatedException extends Exception {
    public LoginDuplicatedException() {
        super("Login already in use");
    }
}
package com.example.PhysioCenter.domain.exceptions;

public class WrongLoginDataException extends Exception {

    public WrongLoginDataException() {
        super("Invalid login data!");
    }
}
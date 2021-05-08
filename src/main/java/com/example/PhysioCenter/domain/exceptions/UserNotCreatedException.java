package com.example.PhysioCenter.domain.exceptions;

public class UserNotCreatedException extends Exception {

    public UserNotCreatedException() {
        super("Failed to create a new User");
    }
}
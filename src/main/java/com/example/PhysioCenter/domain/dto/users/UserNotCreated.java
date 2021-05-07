package com.example.PhysioCenter.domain.dto.users;

public class UserNotCreated extends Exception {

    public UserNotCreated() {
        super("Failed to create a new User");
    }
}
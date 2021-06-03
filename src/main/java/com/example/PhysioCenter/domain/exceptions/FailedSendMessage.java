package com.example.PhysioCenter.domain.exceptions;

public class FailedSendMessage extends Exception {
    public FailedSendMessage() {
        super("Failed to send message");
    }
}

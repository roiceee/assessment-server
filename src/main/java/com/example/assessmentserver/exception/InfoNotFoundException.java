package com.example.assessmentserver.exception;

public class InfoNotFoundException extends RuntimeException {
    public InfoNotFoundException() {
        super("Info not found.");
    }
}

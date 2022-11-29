package com.example.laboratory3.exceptions;

public class InvalidPeriod extends RuntimeException {
    public InvalidPeriod(String errorMessage) {
        super(errorMessage);
    }
}

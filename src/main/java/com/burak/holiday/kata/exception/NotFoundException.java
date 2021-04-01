package com.burak.holiday.kata.exception;

public class NotFoundException extends Exception {

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Object... args) {
        this(String.format(message, args));
    }

    public NotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

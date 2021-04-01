package com.burak.holiday.kata.exception;

public class ForbiddenException extends Exception {

    public final static String FORBIDDEN_MESSAGE = "Forbidden";

    public ForbiddenException(String message) {
        super(message);
    }

    public ForbiddenException(String message, Object... args) {
        this(String.format(message, args));
    }

    public ForbiddenException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
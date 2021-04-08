package com.burak.holiday.kata.exception;

/**
 * Thrown when the requester has no correct authorization rights
 */
public class ForbiddenException extends Exception {

    public static final String FORBIDDEN_MESSAGE = "Forbidden";

    public ForbiddenException(String message) {
        super(message);
    }

    public ForbiddenException(String message, Object... args) {
        this(String.format(message, args));
    }
}
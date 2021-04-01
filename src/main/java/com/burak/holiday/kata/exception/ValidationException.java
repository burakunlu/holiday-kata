package com.burak.holiday.kata.exception;

/**
 * Thrown when the system component does not meet with all the required conditions.
 */
public class ValidationException extends Exception {

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Object... args) {
        this(String.format(message, args));
    }

    public ValidationException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

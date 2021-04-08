package com.burak.holiday.kata.exception;

/**
 * Thrown when the system can not retrieve the item for given conditions
 */
public class NotFoundException extends Exception {

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Object... args) {
        this(String.format(message, args));
    }
}

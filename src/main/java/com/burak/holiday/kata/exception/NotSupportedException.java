package com.burak.holiday.kata.exception;


@SuppressWarnings("serial")
public class NotSupportedException extends RuntimeException {

    public NotSupportedException(String message) {
        super(message);
    }

    public NotSupportedException(String message, Object... args) {
        this(String.format(message, args));
    }

    public NotSupportedException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

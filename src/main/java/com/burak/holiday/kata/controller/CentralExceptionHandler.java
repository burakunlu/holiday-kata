package com.burak.holiday.kata.controller;

import com.burak.holiday.kata.exception.NotFoundException;
import com.burak.holiday.kata.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class CentralExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public void handleBadRequestException(ValidationException ex,
                                          WebRequest request, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(), ex.getLocalizedMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public void handleNotFoundException(NotFoundException ex,
                                        WebRequest request, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value(), ex.getLocalizedMessage());
    }
}

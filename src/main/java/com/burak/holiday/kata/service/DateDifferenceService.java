package com.burak.holiday.kata.service;

import com.burak.holiday.kata.exception.ValidationException;

public interface DateDifferenceService {
    long dateDifference(String start, String end) throws ValidationException;
}

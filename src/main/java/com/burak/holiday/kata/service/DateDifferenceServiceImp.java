package com.burak.holiday.kata.service;

import com.burak.holiday.kata.exception.ValidationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * in time format hh:mm occurs twice. last one has priority.
 */
@Component
public class DateDifferenceServiceImp implements DateDifferenceService {

    private final String format;
    private final SimpleDateFormat simpleDateFormat;

    public DateDifferenceServiceImp(@Value("${dateDifference.format}") final String format) {
        this.format = format;
        this.simpleDateFormat = new SimpleDateFormat(format);
    }

    @Override
    public long dateDifference(String start, String end) throws ValidationException {
        Date startParsed = parseDate(start);
        Date endParsed = parseDate(end);
        startParsed.getTime();
        long diff = Math.abs(startParsed.getTime() - endParsed.getTime());
        return TimeUnit.HOURS.convert(diff, TimeUnit.MILLISECONDS);
    }

    private Date parseDate(String date) throws ValidationException {
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            throw new ValidationException("Date is not in expected format(%s): %s", format, date);
        }
    }
}

package com.burak.holiday.kata.service;

import com.burak.holiday.kata.exception.ValidationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DateDifferenceTests {

    /*
    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
        @Value("${dateDifference.format}")
        String format;

        @Bean
        public DateDifferenceService dateDifferenceService() {
            return new DateDifferenceServiceImp(format);
        }
    }
    */

    @Autowired
    DateDifferenceService dateDifferenceService;

    @Test
    public void shouldReturnDateDifferenceForSameTimeZones() throws ValidationException {
        String start = "2021-04-03T18:36:53[-0400|(+|-)18:36]";
        String end = "2021-04-03T19:36:53[-0400|(+|-)19:36]";

        Long dateDiff = dateDifferenceService.dateDifference(start, end);
        assertEquals(dateDiff, 1);
    }

    @Test
    public void shouldReturnDateDifferenceForDifferentTimeZones() throws ValidationException {
        String currentGermany = "2021-04-04T12:26:33[+0200|(+|-)12:26]";
        String currentTurkey = "2021-04-04T13:26:33[+0300|(+|-)13:26]";

        Long dateDiff = dateDifferenceService.dateDifference(currentGermany, currentTurkey);
        assertEquals(dateDiff, 0);
    }

    @Test
    public void shouldReturnDateDifferenceForDifferentTimeZonesAndDifferentTimes() throws ValidationException {
        String currentGermany = "2021-04-04T12:26:33[+0200|(+|-)12:26]";
        String twoHoursAheadTurkey = "2021-04-04T15:26:33[+0300|(+|-)15:26]";

        Long dateDiff = dateDifferenceService.dateDifference(currentGermany, twoHoursAheadTurkey);
        assertEquals(dateDiff, 2);
    }

    @Test
    public void shouldThrowValidationException_WhenInputIsInvalid() throws Exception {
        String start = "2021-04-03T18:36:53[invalid]";
        String end = "2021-04-03T19:36:53[invalid]";

        Exception expectedException =
                assertThrows(ValidationException.class, () -> dateDifferenceService.dateDifference(start, end));
        assertTrue(expectedException.getMessage().contains("Date is not in expected format"));
    }
}


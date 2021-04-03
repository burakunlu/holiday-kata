package com.burak.holiday.kata.service;

import com.burak.holiday.kata.dto.model.PublicHolidayDto;
import com.burak.holiday.kata.exception.NotFoundException;
import com.burak.holiday.kata.model.CountryInfo;
import com.burak.holiday.kata.model.PublicHoliday;
import com.burak.holiday.kata.model.PublicHolidayType;
import com.burak.holiday.kata.repository.CountryInfoRepository;
import com.burak.holiday.kata.repository.PublicHolidayRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * mock service layer
 * DataJpaTest
 */
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PublicHolidayServiceTests {

    @Autowired
    PublicHolidayRepository publicHolidayRepository;

    @Autowired
    PublicHolidayService publicHolidayService;

    @BeforeEach
    void init() {
        publicHolidayRepository.deleteAll();
    }

    @Test
    // @Sql({"/test.sql"})
    public void shouldAddPublicHoliday() {
        PublicHoliday publicHoliday = new PublicHoliday()
                .setCounties("counties")
                .setCountryCode(new CountryInfo().setCountryCode("CC"))
                .setDate(new Date())
                .setFixed(false)
                .setGlobal(false)
                .setLaunchYear(1900)
                .setLocalName("local name")
                .setName("name")
                .setType(PublicHolidayType.PUBLIC.toString());

        publicHolidayRepository.save(publicHoliday);

        assertEquals(publicHolidayRepository.count(), 1);
    }

    @Test
    public void shouldThrowError_WhenNonNullFieldIsNull() {
        PublicHoliday publicHoliday = new PublicHoliday()
                .setCounties("counties")
                .setCountryCode(new CountryInfo().setCountryCode("DE"))
                .setDate(null)
                .setFixed(false)
                .setGlobal(false)
                .setLaunchYear(1900)
                .setLocalName("local name")
                .setName("name")
                .setType(PublicHolidayType.PUBLIC.toString());

        Exception expectedException =
                assertThrows(DataIntegrityViolationException.class, () -> publicHolidayRepository.save(publicHoliday));
        assertTrue(expectedException.getMessage().contains("not-null property references a null or transient value"));
    }

    @Test
    public void shouldFindByYearAndCountryCode() throws NotFoundException {
        PublicHoliday publicHoliday = new PublicHoliday()
                .setCounties("counties")
                .setCountryCode(new CountryInfo().setCountryCode("DE"))
                .setDate(new Date())
                .setFixed(false)
                .setGlobal(false)
                .setLaunchYear(1900)
                .setLocalName("local name")
                .setName("name")
                .setType(PublicHolidayType.PUBLIC.toString());

        publicHolidayRepository.save(publicHoliday);


        List<PublicHolidayDto> publicHolidays = publicHolidayService.findByYearAndCountryCode(2021, "DE");
        assertEquals(publicHolidays.size(), 1);
    }

    @Test
    public void shouldThrowNotFoundError_WhenThereIsNoCountryInfoAvailable() {
        Exception expectedException =
                assertThrows(NotFoundException.class, () -> publicHolidayService.findByYearAndCountryCode(2021, "non_existing_id"));
        assertTrue(expectedException.getMessage().contains("Country info is not found for given country code"));
    }

}

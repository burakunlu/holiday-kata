package com.burak.holiday.kata.service;

import com.burak.holiday.kata.dto.model.PublicHolidayDto;
import com.burak.holiday.kata.exception.NotFoundException;
import com.burak.holiday.kata.model.CountryInfo;
import com.burak.holiday.kata.model.PublicHoliday;
import com.burak.holiday.kata.model.PublicHolidayType;
import com.burak.holiday.kata.repository.PublicHolidayRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.burak.holiday.kata.TestConstants.EXISTING_COUNTRY_CODE_SPAIN;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Sql({"/test.sql"})
class PublicHolidayServiceTest {

    @Autowired
    PublicHolidayRepository publicHolidayRepository;

    @Autowired
    PublicHolidayService publicHolidayService;

    @BeforeEach
    void init() {
        publicHolidayRepository.deleteAll();
    }

    /**
     * Use a Country Info object generated by using test.sql file
     * Assign Country Info to the Public Holiday by using Country Info ID
     */
    @Test
    void shouldAddPublicHoliday() {
        PublicHoliday publicHoliday = new PublicHoliday()
                .setCounties(new ArrayList<>(Arrays.asList("DE", "BE")))
                .setCountryCode(new CountryInfo().setCountryCode(EXISTING_COUNTRY_CODE_SPAIN))
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
    void shouldThrowError_WhenNonNullFieldIsNull() {
        PublicHoliday publicHoliday = new PublicHoliday()
                .setCounties(new ArrayList<>(Arrays.asList("DE", "BE")))
                .setCountryCode(new CountryInfo().setCountryCode(EXISTING_COUNTRY_CODE_SPAIN))
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
    void shouldFindByYearAndCountryCode() throws NotFoundException {
        PublicHoliday publicHoliday = new PublicHoliday()
                .setCounties(new ArrayList<>(Arrays.asList("DE", "BE")))
                .setCountryCode(new CountryInfo().setCountryCode(EXISTING_COUNTRY_CODE_SPAIN))
                .setDate(new Date())
                .setFixed(false)
                .setGlobal(false)
                .setLaunchYear(1900)
                .setLocalName("local name")
                .setName("name")
                .setType(PublicHolidayType.PUBLIC.toString());

        publicHolidayRepository.save(publicHoliday);

        List<PublicHolidayDto> publicHolidays = publicHolidayService.findByYearAndCountryCode(2021, EXISTING_COUNTRY_CODE_SPAIN);
        assertEquals(publicHolidays.size(), 1);
    }

    @Test
    void shouldThrowNotFoundError_WhenThereIsNoCountryInfoAvailable() {
        Exception expectedException =
                assertThrows(NotFoundException.class, () -> publicHolidayService.findByYearAndCountryCode(2021, "non_existing_id"));
        assertTrue(expectedException.getMessage().contains("Country info is not found for given country code"));
    }

    @TestConfiguration
    static class PublicHolidayServiceTestContextConfiguration {

        @Bean
        public PublicHolidayService publicHolidayService() {
            return new PublicHolidayServiceImp();
        }
    }
}

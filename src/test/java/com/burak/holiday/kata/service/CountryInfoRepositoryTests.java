package com.burak.holiday.kata.service;

import com.burak.holiday.kata.exception.NotFoundException;
import com.burak.holiday.kata.model.CountryInfo;
import com.burak.holiday.kata.model.PublicHoliday;
import com.burak.holiday.kata.model.PublicHolidayType;
import com.burak.holiday.kata.repository.CountryInfoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * mock service layer
 */

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CountryInfoRepositoryTests {

    @Autowired
    CountryInfoRepository countryInfoRepository;

    @BeforeEach
    void init() {
        countryInfoRepository.deleteAll();
    }

    @Test
    void shouldAddCountryInfo() {
        CountryInfo countryInfo = new CountryInfo()
                .setCountryCode("DE")
                .setCommonName("Deutschland")
                .setOfficialName("Deutschland")
                .setRegion("region");

        countryInfoRepository.save(countryInfo);

        assertEquals(countryInfoRepository.count(), 1);
    }
}

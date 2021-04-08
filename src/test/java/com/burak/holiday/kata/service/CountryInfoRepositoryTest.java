package com.burak.holiday.kata.service;

import com.burak.holiday.kata.model.CountryInfo;
import com.burak.holiday.kata.repository.CountryInfoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CountryInfoRepositoryTest {

    @Autowired
    CountryInfoRepository countryInfoRepository;

    @BeforeEach
    void init() {
        countryInfoRepository.deleteAll();
    }

    @Test
    void shouldAddCountryInfo() {
        CountryInfo countryInfo = new CountryInfo()
                .setCountryCode("FR")
                .setCommonName("France")
                .setOfficialName("French Republic")
                .setRegion("Europe");

        countryInfoRepository.save(countryInfo);

        assertEquals(1,  countryInfoRepository.count());
    }
}

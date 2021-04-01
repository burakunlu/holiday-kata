package com.burak.holiday.kata;

import com.burak.holiday.kata.model.CountryInfo;
import com.burak.holiday.kata.model.PublicHoliday;
import com.burak.holiday.kata.model.PublicHolidayType;
import com.burak.holiday.kata.repository.CountryInfoRepository;
import com.burak.holiday.kata.repository.PublicHolidayRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class HolidayKataApplication {

    public static void main(String[] args) {
        SpringApplication.run(HolidayKataApplication.class, args);
    }

    @Bean
    CommandLineRunner init(PublicHolidayRepository publicHolidayRepository, CountryInfoRepository countryInfoRepository) {
        return args -> {

            CountryInfo countryInfoDE = new CountryInfo()
                    .setCountryCode("DE")
                    .setCommonName("common name")
                    .setOfficialName("official name")
                    .setRegion("region")
                    .setPublicHoliday(null);

            CountryInfo countryInfoSavedDE = countryInfoRepository.save(countryInfoDE);

            CountryInfo countryInfoFR = new CountryInfo()
                    .setCountryCode("FR")
                    .setCommonName("France")
                    .setOfficialName("France ")
                    .setRegion("region")
                    .setPublicHoliday(null);

            CountryInfo countryInfoSavedFR = countryInfoRepository.save(countryInfoFR);

            PublicHoliday publicHoliday = new PublicHoliday()
                    .setCounties("counties")
                    .setCountryCode(countryInfoSavedDE)
                    .setDate(new Date())
                    .setFixed(false)
                    .setGlobal(false)
                    .setLaunchYear(1900)
                    .setLocalName("local name")
                    .setName("name")
                    .setType(PublicHolidayType.PUBLIC.toString());

            PublicHoliday publicHolidaySaved = publicHolidayRepository.save(publicHoliday);

            countryInfoSavedDE.setPublicHoliday(publicHolidaySaved);
            countryInfoRepository.save(countryInfoSavedDE);
        };
    }

}

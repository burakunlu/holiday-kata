package com.burak.holiday.kata;

import com.burak.holiday.kata.model.CountryInfo;
import com.burak.holiday.kata.model.PublicHoliday;
import com.burak.holiday.kata.repository.CountryInfoRepository;
import com.burak.holiday.kata.repository.PublicHolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
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


			CountryInfo countryInfo = new CountryInfo()
					.setCountryCode("DE")
					.setCommonName("common name")
					.setOfficialName("official name")
					.setRegion("region")
					.setPublicHoliday(null);

			CountryInfo countryInfoSaved = countryInfoRepository.save(countryInfo);

			PublicHoliday publicHoliday = new PublicHoliday()
					.setCounties("counties")
					.setCountryCode(countryInfoSaved)
					.setDate(new Date())
					.setFixed(false)
					.setGlobal(false)
					.setLaunchYear(2021)
					.setLocalName("local name")
					.setName("name")
					.setType("type");

			PublicHoliday publicHolidaySaved = publicHolidayRepository.save(publicHoliday);

			countryInfoSaved.setPublicHoliday(publicHolidaySaved);
			countryInfoRepository.save(countryInfoSaved);

		};
	}

}

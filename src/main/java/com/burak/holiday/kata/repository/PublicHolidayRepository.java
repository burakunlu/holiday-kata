package com.burak.holiday.kata.repository;

import com.burak.holiday.kata.dto.model.CountryInfoDto;
import com.burak.holiday.kata.model.CountryInfo;
import com.burak.holiday.kata.model.PublicHoliday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicHolidayRepository extends CrudRepository<PublicHoliday, Long> {
    List<PublicHoliday> findByLaunchYearAndCountryCode(int launchYear, CountryInfo countryCode);
}

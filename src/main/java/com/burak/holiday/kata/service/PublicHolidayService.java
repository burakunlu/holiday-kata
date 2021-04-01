package com.burak.holiday.kata.service;

import com.burak.holiday.kata.dto.model.PublicHolidayDto;

import java.util.List;

public interface PublicHolidayService {

    List<PublicHolidayDto> findByLaunchYearAndCountryCode(int launchYear, String countryCode);
}

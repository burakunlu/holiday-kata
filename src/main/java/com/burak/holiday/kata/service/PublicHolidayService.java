package com.burak.holiday.kata.service;

import com.burak.holiday.kata.dto.model.PublicHolidayDto;
import com.burak.holiday.kata.exception.NotFoundException;

import java.util.List;

public interface PublicHolidayService {
    List<PublicHolidayDto> findByYearAndCountryCode(int year, String countryCode) throws NotFoundException;
}

package com.burak.holiday.kata.service;

import com.burak.holiday.kata.dto.mapper.PublicHolidayMapper;
import com.burak.holiday.kata.dto.model.PublicHolidayDto;
import com.burak.holiday.kata.exception.NotFoundException;
import com.burak.holiday.kata.model.CountryInfo;
import com.burak.holiday.kata.repository.CountryInfoRepository;
import com.burak.holiday.kata.repository.PublicHolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PublicHolidayServiceImp implements PublicHolidayService {

    @Autowired
    PublicHolidayRepository publicHolidayRepository;

    @Autowired
    CountryInfoRepository countryInfoRepository;

    @Override
    public List<PublicHolidayDto> findByLaunchYearAndCountryCode(int launchYear, String countryCode) throws NotFoundException {
        CountryInfo countryInfo = requireExistCountryInfo(countryCode);

        List<PublicHolidayDto> publicHolidays = publicHolidayRepository.findByLaunchYearAndCountryCode(launchYear, countryInfo)
                .stream()
                .map(PublicHolidayMapper::toPublicHolidayDto)
                .collect(Collectors.toList());
        return publicHolidays;
    }

    private CountryInfo requireExistCountryInfo(String countryCode) throws NotFoundException {
        Optional<CountryInfo> countryInfo = countryInfoRepository.findById(countryCode);
        return countryInfo.orElseThrow(() -> new NotFoundException("Country info is not found for given country code: " + countryCode));
    }
}

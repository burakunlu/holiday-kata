package com.burak.holiday.kata.dto.mapper;

import com.burak.holiday.kata.dto.model.CountryInfoDto;
import com.burak.holiday.kata.model.CountryInfo;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CountryInfoMapper {
    public static CountryInfoDto toCountryInfoDto(CountryInfo countryInfo) {
        return new CountryInfoDto()
                .setCountryCode(countryInfo.getCountryCode())
                .setCommonName(countryInfo.getCommonName())
                .setOfficialName(countryInfo.getOfficialName())
                .setRegion(countryInfo.getRegion())
                .setPublicHolidays(countryInfo.getPublicHolidays().stream().map(PublicHolidayMapper::toPublicHolidayDto).collect(Collectors.toList()));
    }
}

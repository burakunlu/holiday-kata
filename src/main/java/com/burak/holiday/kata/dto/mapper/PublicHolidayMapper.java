package com.burak.holiday.kata.dto.mapper;

import com.burak.holiday.kata.dto.model.PublicHolidayDto;
import com.burak.holiday.kata.model.PublicHoliday;
import org.springframework.stereotype.Component;

@Component
public class PublicHolidayMapper {
    public static PublicHolidayDto toPublicHolidayDto(PublicHoliday publicHoliday) {
        return new PublicHolidayDto()
                .setCountryCode(publicHoliday.getCountryCode().getCountryCode())
                .setCounties(publicHoliday.getCounties())
                .setDate(publicHoliday.getDate())
                .setFixed(publicHoliday.isFixed())
                .setGlobal(publicHoliday.isGlobal())
                .setLaunchYear(publicHoliday.getLaunchYear())
                .setLocalName(publicHoliday.getLocalName())
                .setName(publicHoliday.getName())
                .setType(publicHoliday.getType());
    }
}

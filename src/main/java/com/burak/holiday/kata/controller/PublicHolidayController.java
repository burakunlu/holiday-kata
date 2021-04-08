package com.burak.holiday.kata.controller;

import com.burak.holiday.kata.dto.model.PublicHolidayDto;
import com.burak.holiday.kata.exception.NotFoundException;
import com.burak.holiday.kata.exception.ValidationException;
import com.burak.holiday.kata.service.PublicHolidayService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.burak.holiday.kata.util.Constraints.requireNonNull;

@RestController
@RequestMapping("/api/v2")
public class PublicHolidayController {

    @Autowired
    PublicHolidayService publicHolidayService;

    @GetMapping("/public-holidays/{year}/{country-code}")
    @ApiOperation(value = "List the public holiday by given year and country", response = PublicHolidayDto.class)
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Public holidays for given year and country is successfully retrieved"),
                    @ApiResponse(code = 400, message = "Invalid or missing required parameters"),
                    @ApiResponse(code = 404, message = "Country information is not found for given country code")
            })
    public List<PublicHolidayDto> getPublicHoliday(@PathVariable(value = "year") int year, @PathVariable(value = "country-code") String countryCode) throws ValidationException, NotFoundException {
        requireNonNull(year, "Year is required, can not be empty!");
        requireNonNull(countryCode, "Country code is required, can not be empty!");

        return publicHolidayService.findByYearAndCountryCode(year, countryCode);
    }

}

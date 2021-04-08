package com.burak.holiday.kata.controller;

import com.burak.holiday.kata.exception.ValidationException;
import com.burak.holiday.kata.service.DateDifferenceService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.burak.holiday.kata.util.Constraints.requireNonNull;

@RestController
@RequestMapping("/api/v2")
public class DateDifferenceController {

    @Autowired
    DateDifferenceService dateDifferenceService;

    @GetMapping("/date-difference")
    @ApiOperation(value = "Date difference in hour for given two dates", response = Long.class)
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Time difference is calculated for given dates"),
                    @ApiResponse(code = 400, message = "Invalid or missing required parameters. Please check date format")
            })
    public Long getDateDifference(@RequestParam(value = "start") String start, @RequestParam(value = "end") String end) throws ValidationException {
        requireNonNull(start, "Start date is required, can not be empty!");
        requireNonNull(end, "End date is required, can not be empty!");

        return dateDifferenceService.dateDifference(start, end);
    }
}

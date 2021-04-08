package com.burak.holiday.kata.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static com.burak.holiday.kata.TestConstants.EXISTING_COUNTRY_CODE_GERMANY;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
class PublicHolidayControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnPublicHolidays() throws Exception {
        mockMvc.perform(get("/api/v2/public-holidays/{year}/{country-code}",2021, EXISTING_COUNTRY_CODE_GERMANY))
        // .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.[0].countryCode", is("DE")))
        .andExpect(jsonPath("$.[0].localName", is("New Year's Day")));
    }

    @Test
    void shouldReturnNotFound_WhenCountryCodeIsNotFound() throws Exception {
        mockMvc.perform(get("/api/v2/public-holidays/{year}/{country-code}",2021, "non_existing_country_code"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldReturnBadRequest_WhenInputIsInvalid() throws Exception {
        mockMvc.perform(get("/api/v2/public-holidays/{year}/{country-code}","invalid_year", EXISTING_COUNTRY_CODE_GERMANY))
                .andExpect(status().isBadRequest());
    }
}

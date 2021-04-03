package com.burak.holiday.kata.controller;

import com.burak.holiday.kata.HolidayKataApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = HolidayKataApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class PublicHolidayControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnPublicHolidays() throws Exception {
        mockMvc.perform(get("/api/v2/public-holidays/{year}/{country-code}",2021, "DE"))
        // .andDo(print())
        .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnNotFound_WhenCountryCodeIsNotFound() throws Exception {
        mockMvc.perform(get("/api/v2/public-holidays/{year}/{country-code}",2021, "TR"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldReturnBadRequest_WhenInputIsInvalid() throws Exception {
        mockMvc.perform(get("/api/v2/public-holidays/{year}/{country-code}","invalid_year", "DE"))
                .andExpect(status().isBadRequest());
    }
}

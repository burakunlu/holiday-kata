package com.burak.holiday.kata.controller;

import com.burak.holiday.kata.HolidayKataApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = HolidayKataApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DateDifferenceControllerIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDateDifference() throws Exception {
        String start = "2021-04-03T18:36:53[-0400|(+|-)18:36]";
        String end = "2021-04-03T19:36:53[-0400|(+|-)19:36]";
        mockMvc.perform(
                    get("/api/v2/date-difference")
                    .param("start", start)
                    .param("end", end)
                )
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

    @Test
    public void shouldReturnBadRequest_WhenInputIsInvalid() throws Exception {
        String start = "2021-04-03T18:36:53[invalid]";
        String end = "2021-04-03T19:36:53[invalid]";
        mockMvc.perform(
                get("/api/v2/date-difference")
                        .param("start", start)
                        .param("end", end)
                )
                .andExpect(status().isBadRequest());
    }
}

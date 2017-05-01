package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.MockMvc;

/**
 * Created by trainer6 on 4/30/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(FlightController.class)
public class FlightControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void testGetFlightJson() throws Exception{
        mvc.perform(get("/flights/flight")).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.Departs").isString())
                .andExpect(jsonPath("$.Tickets").isArray())
                .andExpect(jsonPath("$.Tickets[0].Passenger").exists())
                .andExpect(jsonPath("$.Tickets[0].Passenger.FirstName").isNotEmpty())
                .andExpect(jsonPath("$.Tickets[0].Price").isNotEmpty());
    }

    @Test
    public void testGetFlightsJson() throws Exception{
        mvc.perform(get("/flights")).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$[0].Departs").isString())
                .andExpect(jsonPath("$[0].Tickets").isArray())
                .andExpect(jsonPath("$[0].Tickets[0].Passenger").exists())
                .andExpect(jsonPath("$[0].Tickets[0].Passenger.FirstName").isNotEmpty())
                .andExpect(jsonPath("$[0].Tickets[0].Price").isNotEmpty());
    }


}

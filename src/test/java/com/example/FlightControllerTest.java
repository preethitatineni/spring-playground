package com.example;

import com.example.model.Passenger;
import com.example.model.Ticket;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.MockMvc;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void testPostTicketTotalGson() throws Exception{
        List<Ticket> tickets = new ArrayList<>();
        Ticket ticket = new Ticket();
        Passenger firstPassenger = new Passenger();
        firstPassenger.setLastName("lastname");
        firstPassenger.setFirstName("firstname");
        ticket.setPrice(100);
        ticket.setPassenger(firstPassenger);

        Ticket secondTicket = new Ticket();
        secondTicket.setPrice(75);
        Passenger secondPassenger = new Passenger();
        secondPassenger.setLastName("lastname");
        secondPassenger.setFirstName("firstname");
        secondTicket.setPassenger(secondPassenger);

        tickets.add(ticket);
        tickets.add(secondTicket);

        Gson gson = new GsonBuilder().create();
        String content = gson.toJson(tickets);
        System.out.println(content);
        mvc.perform(post("/flights/tickets/total").contentType(MediaType.APPLICATION_JSON_VALUE).content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(175));
    }

    @Test
    public void testPostTicketTotalStringLiteral() throws Exception{

        String content = "[{\"passenger\":{\"firstName\":\"firstname\",\"lastName\":\"lastname\"},\"price\":100},{\"passenger\":{\"firstName\":\"firstname\",\"lastName\":\"lastname\"},\"price\":75}]";
        mvc.perform(post("/flights/tickets/total").contentType(MediaType.APPLICATION_JSON_VALUE).content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(175));
    }

    @Test
    public void testPostTicketTotalFileFixture() throws Exception{
        URL url = this.getClass().getResource("/content.json");
        String content = new String(Files.readAllBytes(Paths.get(url.getFile())));
        mvc.perform(post("/flights/tickets/total").contentType(MediaType.APPLICATION_JSON_VALUE).content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(175));

    }


}

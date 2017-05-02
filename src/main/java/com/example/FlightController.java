package com.example;

import com.example.model.Flight;
import com.example.model.Passenger;
import com.example.model.Ticket;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by trainer6 on 4/30/17.
 */
@RestController
public class FlightController {

    @GetMapping("flights/flight")
    public @ResponseBody
    Flight getFlight(){
        Flight flight = new Flight();
        Date departs = new Date();
        Calendar cal = Calendar.getInstance();
        departs = cal.getTime();
        flight.setDeparts(departs);

        List<Ticket> tickets = new ArrayList<>();
        Ticket ticket = new Ticket();
        Passenger passenger = new Passenger();
        passenger.setFirstName("FirstName");
        passenger.setLastName("LastName");
        ticket.setPassenger(passenger);
        ticket.setPrice(200);
        tickets.add(ticket);
        flight.setTickets(tickets);
        return flight;
    }

    @GetMapping("/flights")
    public List<Flight> getFlights(){
        List<Flight> flights = new ArrayList<>();
        Flight flight = new Flight();
        Date departs = new Date();
        Calendar cal = Calendar.getInstance();
        departs = cal.getTime();
        flight.setDeparts(departs);

        List<Ticket> tickets = new ArrayList<>();
        Ticket ticket = new Ticket();
        Passenger passenger = new Passenger();
        passenger.setFirstName("FirstName");
        //passenger.lastName = "LastName";
        ticket.setPassenger(passenger);
        ticket.setPrice(200);
        tickets.add(ticket);
        flight.setTickets(tickets);
        flights.add(flight);
        return flights;
    }

    @PostMapping("/flights/tickets/total")
    public String ticketsTotal(@RequestBody List<Ticket> ticketList){
        int result = 0;
        for(Ticket ticket : ticketList){
            result += ticket.getPrice();
        }
        String response = String.format("{ \"result\":  %s }", result);
        return response;
    }
}

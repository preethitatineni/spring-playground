package com.example;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by trainer6 on 4/30/17.
 */
@RestController
public class FlightController {

    @GetMapping("flights/flight")
    public @ResponseBody Flight getFlight(){
        Flight flight = new Flight();
        Date departs = new Date();
        Calendar cal = Calendar.getInstance();
        departs = cal.getTime();
        flight.departs = departs;

        List<Ticket> tickets = new ArrayList<>();
        Ticket ticket = new Ticket();
        Passenger passenger = new Passenger();
        passenger.firstName = "FirstName";
        passenger.lastName = "LastName";
        ticket.passenger = passenger;
        ticket.price = 200;
        tickets.add(ticket);
        flight.tickets = tickets;

        return flight;
    }

    @GetMapping("/flights")
    public List<Flight> getFlights(){
        List<Flight> flights = new ArrayList<>();
        Flight flight = new Flight();
        Date departs = new Date();
        Calendar cal = Calendar.getInstance();
        departs = cal.getTime();
        flight.departs = departs;

        List<Ticket> tickets = new ArrayList<>();
        Ticket ticket = new Ticket();
        Passenger passenger = new Passenger();
        passenger.firstName = "FirstName";
        //passenger.lastName = "LastName";
        ticket.passenger = passenger;
        ticket.price = 200;
        tickets.add(ticket);
        flight.tickets = tickets;
        flights.add(flight);
        return flights;
    }

    static class Flight{
        public Date getDeparts() {
            return departs;
        }

        public void setDeparts(Date departs) {
            this.departs = departs;
        }

        @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
                @JsonProperty("Departs")
        Date departs = new Date();

        public List<Ticket> getTickets() {
            return tickets;
        }

        public void setTickets(List<Ticket> tickets) {
            this.tickets = tickets;
        }
        @JsonProperty("Tickets")
        List<Ticket> tickets = Collections.emptyList();
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    static class Ticket{
        public Passenger getPassenger() {
            return passenger;
        }

        public void setPassenger(Passenger passenger) {
            this.passenger = passenger;
        }
        @JsonProperty("Passenger")
        Passenger passenger = new Passenger();

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        @JsonProperty("Price")
        int price = 0;
    }

    static class Passenger{
        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
        @JsonProperty("FirstName")
        String firstName;
        String lastName;
    }
}

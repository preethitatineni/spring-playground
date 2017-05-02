package com.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by trainer6 on 5/1/17.
 */
public class Flight {
    public Date getDeparts() {
        return departs;
    }

    public void setDeparts(Date departs) {
        this.departs = departs;
    }

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    Date departs = new Date();

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    List<Ticket> tickets = Collections.emptyList();
}

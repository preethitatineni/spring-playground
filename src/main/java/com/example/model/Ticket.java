package com.example.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by trainer6 on 5/1/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ticket {


        public Passenger getPassenger() {
            return passenger;
        }

        public void setPassenger(Passenger passenger) {
            this.passenger = passenger;
        }
        Passenger passenger = new Passenger();

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        int price = 0;

}

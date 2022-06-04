package com.flightmanagement.flightmanagement.airline;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Statistic {

    private int totalFlight;
    private int totalTicket;
    private int totalPrice;
}

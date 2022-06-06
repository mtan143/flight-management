package com.flightmanagement.flightmanagement.airline;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Statistic {

    private Integer totalFlight = 0;
    private Integer totalTicket = 0;
    private Integer totalPrice = 0;

}

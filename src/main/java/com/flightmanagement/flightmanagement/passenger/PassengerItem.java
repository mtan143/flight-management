package com.flightmanagement.flightmanagement.passenger;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerItem {

    private String appellation;
    private String first_name;
    private String last_name;
    private Date date_of_birth;
    private String nationality;
    private String flight_code;
    private String airline_name;
    private String flight_name;
    private String time_departure;
    private String time_arrival;
    private String total_price;
}

package com.flightmanagement.flightmanagement.common;

import com.flightmanagement.flightmanagement.flight.FlightStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchObject {

    private Integer flight_id;
    private String flight_code;
    private String flight_name;
    private String airline_name;
    private FlightStatus flight_status;
    private String departure;
    private int time;
    private String time_departure;
    private String time_arrival;
    private String gate_id;
    private int price;

}

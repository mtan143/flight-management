package com.flightmanagement.flightmanagement.flight;

import lombok.Data;

import java.util.Date;

@Data
public class FlightItem {

    private Integer flightId;
    private String flightCode;
    private String name;
    private int airlineId;
    private FlightStatus flightStatus;
    private Date departure;
    private String departurePlace;
    private String destination;
    private int time;
    private String gateId;


}

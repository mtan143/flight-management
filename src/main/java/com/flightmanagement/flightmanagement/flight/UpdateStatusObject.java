package com.flightmanagement.flightmanagement.flight;

import lombok.Data;

@Data
public class UpdateStatusObject {

    private String flightCode;
    private FlightStatus flightStatus;
}

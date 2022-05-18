package com.flightmanagement.flightmanagement.flight;

import com.flightmanagement.flightmanagement.flight.classtype.ClassFlightManage;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class ResultFlight {

    private String name;
    private String flightCode;
    private String departure;
    private String gateId;
    private int quantityTicket;
    private String timeDeparture;
    private String timeArrival;
    private FlightStatus flightStatus;

    private List<ClassFlightManage> classTypeList;

}

package com.flightmanagement.flightmanagement.flight;

import com.flightmanagement.flightmanagement.flight.classtype.ClassType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ItemSearch {

    private String departurePlace;

    private String destination;

    private int quantity;

    private ClassType classType;

    private LocalDateTime departure;
}

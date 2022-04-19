package com.flightmanagement.flightmanagement.flight;

import com.flightmanagement.flightmanagement.flight.classtype.ClassType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class SearchItem {
    private String departurePlace;
    private String destination;
    private int quantity;
    private ClassType classType;
    private Date departure;

}

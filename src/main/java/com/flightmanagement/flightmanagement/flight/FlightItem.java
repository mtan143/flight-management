package com.flightmanagement.flightmanagement.flight;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class FlightItem {

    private String name;
    private int airlineId;
    private Date departure;
    private String departurePlace;
    private String destination;
    private int time;
    private String gateId;
    private int quantityTicket;
    private String timeDeparture;
    private String timeArrival;

    private int stdQuantity;
    private int stdPrice;

//    private int ptPrice;
//    private int ptQuantity;
//
//    private int pt_dbPrice;
//    private int pt_dbQuantity;
//
//    private int tgPrice;
//    private int tgQuantity;
//
//    private int hnPrice;
//    private int hnQuantity;



}

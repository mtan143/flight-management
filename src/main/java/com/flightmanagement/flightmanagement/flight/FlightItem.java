package com.flightmanagement.flightmanagement.flight;

import com.flightmanagement.flightmanagement.flight.classtype.ClassType;
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

    private ClassType pt;
    private String ptCode;
    private int ptPrice;
    private int ptQuantity;

    private ClassType pt_db;
    private String pt_dbCode;
    private int pt_dbPrice;
    private int pt_dbQuantity;

    private ClassType tg;
    private String tgCode;
    private int tgPrice;
    private int tgQuantity;

    private ClassType hn;
    private String hnCode;
    private int hnPrice;
    private int hnQuantity;



}

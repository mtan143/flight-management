package com.flightmanagement.flightmanagement.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Transaction {

    private int id;
    private Date time;
    private String ticketCode;
    private int totalPrice;
    private TicketStatus ticketStatus;
    private String departurePlace;
    private String destination;
    private String typeId;

}

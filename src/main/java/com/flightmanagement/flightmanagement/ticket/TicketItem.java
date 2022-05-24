package com.flightmanagement.flightmanagement.ticket;


import com.flightmanagement.flightmanagement.passenger.Passenger;
import lombok.Data;

import java.util.List;

@Data
public class TicketItem {

    private String classFlightCode;

    private Integer userId;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String email;

    private TicketStatus ticketStatus;

    private int totalPrice;

    private Status status;

    private String voucherCode;

    private String giftCode;

    private String chargeId;

    private List<Passenger> passengers;
}

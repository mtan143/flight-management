package com.flightmanagement.flightmanagement.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class HistoryTransaction {

    private int id;
    private LocalDateTime time;
    private String ticketCode;
    private int totalPrice;
    private TicketStatus ticketStatus;
    private String departurePlace;
    private String destination;

}

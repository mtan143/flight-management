package com.flightmanagement.flightmanagement.ticket;


import com.flightmanagement.flightmanagement.passenger.PassengerItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponse {

    private Ticket ticket;
    private List<PassengerItem> passengers;
    private Date departure;
}

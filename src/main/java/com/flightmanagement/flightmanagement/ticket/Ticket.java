package com.flightmanagement.flightmanagement.ticket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ticket {

    @Id
    @SequenceGenerator(
            name = "ticket_id_sequence",
            sequenceName = "ticket_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ticket_id_sequence"
    )
    private Integer id;
    @Column(name = "ticketCode")
    private String ticketCode;
    @Column(name = "classFlightCode")
    private String classFlightCode;

    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "ticketStatus")
    private TicketStatus ticketStatus;
    @Column(name = "totalPrice")
    private int totalPrice;

    @Column(name = "status")
    private Status status;

    @Column(name = "couponCode")
    private String couponCode;
    @Column(name = "voucherCode")
    private String voucherCode;


    @Column(name = "createdBy")
    private String createdBy;
    @Column(name = "createdDate")
    private LocalDateTime createdDate;
    @Column(name = "lastUpdateBy")
    private String lastUpdateBy;
    @Column(name = "lastUpdateDate")
    private LocalDateTime lastUpdateDate;

}

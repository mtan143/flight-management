package com.flightmanagement.flightmanagement.ticket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("tbl_Ticket")
public class Ticket {

    @Id
    @Column("ticketId")
    private Integer ticketId;

    @Column("ticketCode")
    private String ticketCode;

    @Column("classFlightId")
    private int classFlightId;

    @Column("userId")
    private Integer userId;

    @Column("firstName")
    private String firstName;

    @Column("lastName")
    private String lastName;

    @Column("phoneNumber")
    private String phoneNumber;

    @Column("email")
    private String email;

    @Column("name")
    private TicketStatus ticketStatus;

    @Column("name")
    private int totalPrice;

    @Column("name")
    private Status status;

    @Column("name")
    private String voucherCode;



    @Column("createdBy")
    private String createdBy;

    @Column("createdDate")
    private Date createdDate;

    @Column("lastUpdateBy")
    private String lastUpdateBy;

    @Column("lastUpdateDate")
    private Date lastUpdateDate;

}

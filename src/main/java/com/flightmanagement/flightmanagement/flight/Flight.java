package com.flightmanagement.flightmanagement.flight;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("tbl_Flight")
public class Flight {

    @Id
    @Column("flightId")
    private Integer flightId;

    @Column("flightCode")
    private String flightCode;

    @Column("name")
    private String name;

    @Column("airlineId")
    private int airlineId;

    @Column("flightStatus")
    private FlightStatus flightStatus;

    @Column("departure")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date departure;

    @Column("quantityTicket")
    private int quantityTicket;

    @Column("name")
    private String departurePlace;

    @Column("destination")
    private String destination;

    @Column("time")
    private int time;

    @Column("gateId")
    private String gateId;

    @Column("status")
    private Status status;


    @Column("createdBy")
    private String createdBy;

    @Column("createdDate")
    private Date createdDate;

    @Column("lastUpdateBy")
    private String lastUpdateBy;

    @Column("lastUpdateDate")
    private Date lastUpdateDate;
}

package com.flightmanagement.flightmanagement.flight;

import com.flightmanagement.flightmanagement.flight.classtype.ClassFlightManage;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Flight {

    @Id
    @SequenceGenerator(
            name = "flight_id_sequence",
            sequenceName = "flight_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "flight_id_sequence"
    )
    private Integer id;
    @Column(name = "flightCode")
    private String flightCode;
    @Column(name = "name")
    private String name;
    @Column(name = "airlineCode")
    private String airlineCode;
    @Column(name = "flightStatus")
    private FlightStatus flightStatus;
    @Column(name = "departure")
    private LocalDateTime departure;
    @Column(name = "quantityTicket")
    private int quantityTicket;
    @Column(name = "departurePlace")
    private String departurePlace;
    @Column(name = "destination")
    private String destination;
    @Column(name = "time")
    private int time;
    @Column(name = "gateId")
    private String gateId;

    @Column(name = "status")
    private Status status;

    @Column(name = "createdBy")
    private String createdBy;
    @Column(name = "createdDate")
    private LocalDateTime createdDate;
    @Column(name = "lastUpdateBy")
    private String lastUpdateBy;
    @Column(name = "lastUpdateDate")
    private LocalDateTime lastUpdateDate;
}

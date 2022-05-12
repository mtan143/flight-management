package com.flightmanagement.flightmanagement.flight;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("tbl_Flight")
public class Flight implements Persistable {

    public Flight(String name, int airlineId, FlightStatus flightStatus,
                  Date departure, int quantityTicket, String departurePlace, String destination, int time,
                  String timeDeparture, String timeArrival, String gateId, Status status, String createdBy,
                  Date createdDate, String lastUpdateBy, Date lastUpdateDate) {

        this.flightCode = generateFlightCode();
        this.name = name;
        this.airlineId = airlineId;
        this.flightStatus = flightStatus;
        this.departure = departure;
        this.quantityTicket = quantityTicket;
        this.departurePlace = departurePlace;
        this.destination = destination;
        this.time = time;
        this.timeDeparture = timeDeparture;
        this.timeArrival = timeArrival;
        this.gateId = gateId;
        this.status = status;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastUpdateBy = lastUpdateBy;
        this.lastUpdateDate = lastUpdateDate;
    }

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

    @Column("departurePlace")
    private String departurePlace;

    @Column("destination")
    private String destination;

    @Column("time")
    private int time;

    @Column("timeDeparture")
    private String timeDeparture;

    @Column("timeArrival")
    private String timeArrival;

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

    @Transient
    @JsonIgnore
    private boolean newEntity;

    @Override
    public Object getId() {
        return flightId;
    }

    public void setNew(boolean newInstance) {
        this.newEntity = newInstance;
    }

    @Override
    @JsonIgnore
    public boolean isNew() {
        return newEntity;
    }

    public String parsePlace (String place) {
        switch (place.substring(0, place.length() - 10)) {
            case "Da Nang": return "DAD";
            case "Ha Noi": return "HAN";
            case "Da Lat": return "DLI";
            case "Nha Trang": return "CXR";
            case "Phu Quoc": return "PQC";
            case "Hue": return "HUI";
            case "Vinh": return "VII";
            default: return "SGN";

        }
    }

    public String generateFlightCode() {
        return String.format("%04d", airlineId)
                .concat(timeDeparture.substring(0, 2))
                .concat(timeDeparture.substring(3, 5))
                .concat(departure.toString().substring(8, 10))
                .concat(departure.toString().substring(5, 7))
                .concat(departure.toString().substring(2, 4))
                .concat(parsePlace(departurePlace))
                .concat(parsePlace(destination));
    }

}

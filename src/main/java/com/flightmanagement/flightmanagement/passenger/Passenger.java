package com.flightmanagement.flightmanagement.passenger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Passenger {

    @Id
    @SequenceGenerator(
            name = "passenger_id_sequence",
            sequenceName = "passenger_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "passenger_id_sequence"
    )
    private Integer id;
    @Column(name = "ticketCode")
    private String ticketCode;

    @Column(name = "appellation")
    private String appellation;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "dateOfBirth")
    private LocalDateTime dateOfBirth;
    @Column(name = "nationality")
    private String nationality;

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

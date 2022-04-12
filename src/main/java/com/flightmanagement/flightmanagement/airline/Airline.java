package com.flightmanagement.flightmanagement.airline;

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
public class Airline {

    @Id
    @SequenceGenerator(
            name = "user_id_sequence",
            sequenceName = "user_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_id_sequence"
    )
    private Integer id;
    @Column(name = "airlineCode")
    private String airlineCode;
    @Column(name = "name")
    private String name;
    @Column(name = "foundDate")
    private LocalDateTime foundDate;
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

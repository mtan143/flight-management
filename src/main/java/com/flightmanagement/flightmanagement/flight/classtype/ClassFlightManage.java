package com.flightmanagement.flightmanagement.flight.classtype;

import com.flightmanagement.flightmanagement.flight.Flight;
import com.flightmanagement.flightmanagement.flight.Status;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ClassFlightManage {

    @Id
    @SequenceGenerator(
            name = "classtype_id_sequence",
            sequenceName = "classtype_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "classtype_id_sequence"
    )
    private Integer id;
    @Column(name = "classFlightCode")
    private String classFlightCode;
    @Column(name = "classType")
    private ClassType classType;
    @Column(name = "price")
    private int price;

    @Column(name = "quantity")
    private int quantity;
    @Column(name = "remainingQuantity")
    private int remainingQuantity;

    @Column(name = "status")
    private Status status;
    @Column(name = "flightCode")
    private String flightCode;

    @Column(name = "createdBy")
    private String createdBy;
    @Column(name = "createdDate")
    private LocalDateTime createdDate;
    @Column(name = "lastUpdateBy")
    private String lastUpdateBy;
    @Column(name = "lastUpdateDate")
    private LocalDateTime lastUpdateDate;

}

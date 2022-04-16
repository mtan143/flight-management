package com.flightmanagement.flightmanagement.flight.classtype;

import com.flightmanagement.flightmanagement.flight.Status;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("tbl_ClassType")
public class ClassFlightManage {

    @Id
    @Column("classFlightId")
    private Integer classFlightId;

    @Column("classFlightCode")
    private String classFlightCode;

    @Column("classType")
    private ClassType classType;

    @Column("price")
    private int price;

    @Column("quantity")
    private int quantity;

    @Column("remainingQuantity")
    private int remainingQuantity;


    @Column("status")
    private Status status;

    @Column("flightId")
    private int flightId;


    @Column("createdBy")
    private String createdBy;

    @Column("createdDate")
    private Date createdDate;

    @Column("lastUpdateBy")
    private String lastUpdateBy;

    @Column("lastUpdateDate")
    private Date lastUpdateDate;

}

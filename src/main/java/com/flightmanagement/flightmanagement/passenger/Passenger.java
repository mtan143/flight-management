package com.flightmanagement.flightmanagement.passenger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("tbl_Passenger")
public class Passenger {

    @Id
    @Column("passengerId")
    private Integer passengerId;

    @Column("ticketId")
    private int ticketId;

    @Column("appellation")
    private String appellation;

    @Column("firstName")
    private String firstName;

    @Column("lastName")
    private String lastName;

    @Column("dateOfBirth")
    private Date dateOfBirth;

    @Column("nationality")
    private String nationality;

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

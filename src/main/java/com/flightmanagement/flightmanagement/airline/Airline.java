package com.flightmanagement.flightmanagement.airline;

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
@Table("tbl_Airline")
public class Airline {

    @Id
    @Column("airlineId")
    private Integer airlineId;

    @Column("airlineCode")
    private String airlineCode;

    @Column("name")
    private String name;

    @Column("foundDate")
    private Date foundDate;

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

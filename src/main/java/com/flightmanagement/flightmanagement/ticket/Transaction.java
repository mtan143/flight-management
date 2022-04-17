package com.flightmanagement.flightmanagement.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Data
@AllArgsConstructor
@Table("tbl_Transaction")
public class Transaction {

    @Id
    @Column("transactionId")
    private int id;

    @Column("typeId")
    private String typeId;

    @Column("userId")
    private int userId;

    @Column("time")
    private Date time;

    @Column("appId")
    private String appId;

    @Column("transactionValue")
    private int transactionValue;

    @Column("partnerId")
    private String partnerId;

    @Column("revenue")
    private int revenue;

    @Column("commission")
    private int commission;

}

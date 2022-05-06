package com.flightmanagement.flightmanagement.ticket;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Data
@AllArgsConstructor
@Table("tbl_Transaction")
public class Transaction implements Persistable {

    @Id
    @Column("transactionId")
    private int transactionId;

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

    @Transient
    @JsonIgnore
    private boolean newEntity;

    @Override
    public Object getId() {
        return transactionId;
    }

    public void setNew(boolean newInstance) {
        this.newEntity = newInstance;
    }

    @Override
    @JsonIgnore
    public boolean isNew() {
        return newEntity;
    }
}

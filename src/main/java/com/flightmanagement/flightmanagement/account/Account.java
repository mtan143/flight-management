package com.flightmanagement.flightmanagement.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("tbl_Account")
public class Account implements Persistable {

    public Account(String partnerId, String airlineCode, String createdBy, Date createdDate, String lastUpdateBy, Date lastUpdateDate) {
        this.partnerId = partnerId;
        this.airlineCode = airlineCode;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastUpdateBy = lastUpdateBy;
        this.lastUpdateDate = lastUpdateDate;
    }

    @Id
    @Column("accountId")
    private Integer accountId;

    @Column("partnerId")
    private String partnerId;

    @Column("airlineCode")
    private String airlineCode;


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
        return accountId;
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
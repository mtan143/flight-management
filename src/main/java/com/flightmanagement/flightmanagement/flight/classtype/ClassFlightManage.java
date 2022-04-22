package com.flightmanagement.flightmanagement.flight.classtype;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flightmanagement.flightmanagement.flight.Status;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("tbl_ClassType")
public class ClassFlightManage implements Persistable {

    public ClassFlightManage(Integer classFlightId, String classFlightCode, ClassType classType,
                             int price, int quantity, int remainingQuantity, Status status, int flightId,
                             String createdBy, Date createdDate, String lastUpdateBy, Date lastUpdateDate) {
        this.classFlightId = classFlightId;
        this.classFlightCode = classFlightCode;
        this.classType = classType;
        this.price = price;
        this.quantity = quantity;
        this.remainingQuantity = remainingQuantity;
        this.status = status;
        this.flightId = flightId;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastUpdateBy = lastUpdateBy;
        this.lastUpdateDate = lastUpdateDate;
    }

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

    @Transient
    @JsonIgnore
    private boolean newEntity;

    @Override
    public Object getId() {
        return classFlightId;
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

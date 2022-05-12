package com.flightmanagement.flightmanagement.flight.classtype;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flightmanagement.flightmanagement.flight.Status;
import lombok.*;
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
@Table("tbl_ClassType")
public class ClassFlightManage implements Persistable {

    public ClassFlightManage(ClassType classType,
                             int price, int quantity, int remainingQuantity, Status status, int flightId,
                             String createdBy, Date createdDate, String lastUpdateBy, Date lastUpdateDate) {
        this.classType = classType;
        this.classFlightCode = generateFlightCode();
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

    private String generateFlightCode() {
        return String.format("%04d", flightId)
                .concat(changeClassType(classType))
                .concat(String.format("%04d", classFlightId));
    }
    private String changeClassType(ClassType classType) {
        switch (classType) {
            case PHO_THONG: return "PTXX";
            case PHO_THONG_DAC_BIET: return "PTDB";
            case THUONG_GIA: return "TGXX";
            default: return "HNXX";
        }
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

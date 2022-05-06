package com.flightmanagement.flightmanagement.passenger;

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

import javax.annotation.Generated;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("tbl_Passenger")
public class Passenger implements Persistable {

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

    @Transient
    @JsonIgnore
    private boolean newEntity;

    @Override
    public Object getId() {
        return passengerId;
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

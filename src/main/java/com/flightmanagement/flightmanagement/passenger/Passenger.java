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
import java.time.Instant;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("tbl_Passenger")
public class Passenger implements Persistable {

    public Passenger(int ticketId, String appellation, String firstName, String lastName, Date dateOfBirth, String nationality) {
        this.ticketId = ticketId;
        this.appellation = appellation;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.status = Status.ACTIVE;
        this.createdBy = "ADMIN";
        this.createdDate = Date.from(Instant.now());
        this.lastUpdateBy = "ADMIN";
        this.lastUpdateDate = Date.from(Instant.now());
        this.setNewEntity(true);
    }

    @Id
    @Column("passengerId")
    private Integer passengerId;

    @Column("ticketId")
    @JsonIgnore
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
    @JsonIgnore
    private Status status;


    @Column("createdBy")
    @JsonIgnore
    private String createdBy;

    @Column("createdDate")
    @JsonIgnore
    private Date createdDate;

    @Column("lastUpdateBy")
    @JsonIgnore
    private String lastUpdateBy;

    @Column("lastUpdateDate")
    @JsonIgnore
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

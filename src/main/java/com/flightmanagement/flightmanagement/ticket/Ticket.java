package com.flightmanagement.flightmanagement.ticket;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table("tbl_Ticket")
public class Ticket implements Persistable {

    @Id
    @Generated
    @Column("ticketId")
    private Integer ticketId;

    @Column("ticketCode")
    private String ticketCode;

    @Column("classFlightId")
    private int classFlightId;

    @Column("userId")
    private Integer userId;

    @Column("firstName")
    private String firstName;

    @Column("lastName")
    private String lastName;

    @Column("phoneNumber")
    private String phoneNumber;

    @Column("email")
    private String email;

    @Column("ticketStatus")
    private TicketStatus ticketStatus;

    @Column("totalPrice")
    private int totalPrice;

    @Column("status")
    private Status status;

    @Column("voucherCode")
    private String voucherCode;



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
        return ticketId;
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

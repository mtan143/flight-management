package com.flightmanagement.flightmanagement.ticket;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("tbl_Ticket")
public class Ticket implements Persistable {

    public Ticket(String ticketCode, int classFlightId, Integer userId, String firstName, String lastName, String phoneNumber, String email, int totalPrice, String voucherCode, String giftCode, String chargeId) {
        this.ticketCode = ticketCode;
        this.classFlightId = classFlightId;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.totalPrice = totalPrice;
        this.voucherCode = voucherCode == null ? "" : voucherCode;
        this.giftCode = giftCode == null ? "" : giftCode;
        this.status = Status.ACTIVE;
        this.ticketStatus = TicketStatus.Tao;
        this.createdBy = "ADMIN";
        this.createdDate = Date.from(Instant.now());
        this.lastUpdateBy = "ADMIN";
        this.lastUpdateDate = Date.from(Instant.now());
        this.chargeId = chargeId;
        this.setNew(true);
    }

    @Id
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

    @Column("giftCode")
    private String giftCode;

    @Column("chargeId")
    private String chargeId;



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

package com.flightmanagement.flightmanagement.ticket;

import com.flightmanagement.flightmanagement.exception.BaseError;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public enum TicketError implements BaseError {
    TICKET_INVALID("TICKET_INVALID", "Ticket is invalid"),
    TICKET_CODE_INVALID("TICKET_CODE_INVALID", "Ticket code is invalid"),
    CLASS_FLIGHT_INVALID("CLASS_FLIGHT_INVALID", "Class flight code is invalid"),
    FIRSTNAME_EMPTY("FIRSTNAME_EMPTY", "First name is required!"),
    LASTNAME_EMPTY("LASTNAME_EMPTY", "Last name is required!"),
    PHONE_NUMBER_INVALID("PHONE_NUMBER_INVALID", "Phone number is invalid!"),
    EMAIL_INVALID("EMAIL_INVALID", "Email is required!"),
    PRICE_INVALID("PRICE_INVALID", "Price is invalid!"),
    CHARGE_NOT_EXIST("CHARGE_NOT_EXIST", "Ticket was not check out"),
    TICKET_NOT_EXIST("TICKET_NOT_EXIST", "Ticket is not existing");

    private String code;
    private String message;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

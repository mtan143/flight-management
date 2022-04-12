package com.flightmanagement.flightmanagement.passenger;

import com.flightmanagement.flightmanagement.exception.BaseError;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public enum PassengerError implements BaseError {
    PASSENGER_INVALID("PASSENGER_INVALID", "Passenger is invalid"),
    TICKET_CODE_INVALID("TICKET_CODE_INVALID", "Ticket code is invalid"),
    FIRSTNAME_EMPTY("FIRSTNAME_EMPTY", "First name is required!"),
    LASTNAME_EMPTY("LASTNAME_EMPTY", "Last name is required!"),
    PASSENGER_NOT_EXIST("PASSENGER_NOT_EXIST", "Passenger is not existing");

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

package com.flightmanagement.flightmanagement.flight;

import com.flightmanagement.flightmanagement.exception.BaseError;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public enum FlightError implements BaseError {
    FLIGHT_INVALID("FLIGHT_INVALID", "Flight is invalid"),
    FLIGHT_ID("FLIGHT_ID", "Flight ID is invalid"),
    FLIGHT_CODE_EMPTY("FLIGHT_CODE_EMPTY", "Flight code is required!"),
    AIRLINE_CODE_EMPTY("AIRLINE_CODE_EMPTY", "Airline code is required!"),
    GATE_EMPTY("GATE_EMPTY", "Gate ID is required!"),
    FLIGHT_NOT_EXIST("FLIGHT_NOT_EXIST", "Flight is not existing"),
    FLIGHT_NOT_FOUND("FLIGHT_NOT_FOUND", "Flight not found! Try again!");

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

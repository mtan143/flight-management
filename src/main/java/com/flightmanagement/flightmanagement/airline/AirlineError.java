package com.flightmanagement.flightmanagement.airline;

import com.flightmanagement.flightmanagement.exception.BaseError;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public enum AirlineError implements BaseError {
    AIRLINE_ID("AIRLINE_ID", "Airline ID is invalid"),
    AIRLINE_INVALID("AIRLINE_INVALID", "Airline is invalid"),
    NAME_EMPTY("NAME_EMPTY", "Name is empty"),
    AIRLINE_CODE_INVALID("AIRLINE_CODE_INVALID", "Airline  is invalid"),
    AIRLINE_NOT_EXIST("AIRLINE_NOT_EXIST", "Airline is not existing!"),
    AIRLINE_ALREADY_EXIST("AIRLINE_ALREADY_EXIST", "Airline has already existed!");

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

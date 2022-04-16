package com.flightmanagement.flightmanagement.flight.classtype;

import com.flightmanagement.flightmanagement.exception.BaseError;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public enum ClassFlightError implements BaseError {
    CLASS_FLIGHT_ID("CLASS_FLIGHT_ID", "CLASS_FLIGHT ID is invalid"),
    CLASS_FLIGHT_INVALID("CLASS_FLIGHT_INVALID", "CLASS_FLIGHT is invalid"),
    CLASS_FLIGHT_CODE_INVALID("CLASS_FLIGHT_CODE_INVALID", "CLASS_FLIGHT  is invalid"),
    PRICE_INVALID("PRICE_INVALID", "Price of flight is out of barem"),
    QUANTITY_INVALID("QUANTITY_INVALID", "Remaining quantity must lower or equal than total quantity!"),
    CLASS_FLIGHT_NOT_EXIST("CLASS_FLIGHT_NOT_EXIST", "CLASS_FLIGHT is not existing!"),
    CLASS_FLIGHT_ALREADY_EXIST("CLASS_FLIGHT_ALREADY_EXIST", "CLASS_FLIGHT has already existed!");

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

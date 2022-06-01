package com.flightmanagement.flightmanagement.account;

import com.flightmanagement.flightmanagement.exception.BaseError;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public enum AccountError implements BaseError {
    AIRLINE_ID("AIRLINE_ID", "Airline ID is invalid"),
    ACCOUNT_INVALID("ACCOUNT_INVALID", "Account is invalid"),
    PARTNER_ID_EMPTY("NAME_EMPTY", "Name is empty"),
    AIRLINE_CODE_EMPTY("AIRLINE_CODE_EMPTY", "Airline code is empty"),
    ACCOUNT_NOT_EXIST("ACCOUNT_NOT_EXIST", "Account is not existing!"),
    ACCOUNT_ALREADY_EXIST("ACCOUNT_ALREADY_EXIST", "Account has already existed!");

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

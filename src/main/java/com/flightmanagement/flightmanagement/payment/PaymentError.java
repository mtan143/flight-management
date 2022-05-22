package com.flightmanagement.flightmanagement.payment;

import com.flightmanagement.flightmanagement.exception.BaseError;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public enum PaymentError implements BaseError {
    PAYMENT_INVALID("PAYMENT_INVALID", "Please check the credit card details entered"),
    TRANSACTION_INVALID("TRANSACTION_INVALID", "Please check your information"),
    REFUND_INVALID("REFUND_INVALID", "Refund Failed");

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
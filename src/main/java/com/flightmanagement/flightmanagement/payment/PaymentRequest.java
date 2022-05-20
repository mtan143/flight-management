package com.flightmanagement.flightmanagement.payment;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentRequest {

    public enum Currency{
        INR, USD, VND
    }
    private String description;
    private int amount;
    private Currency currency;
    private String stripeEmail;
    private Token token;

}

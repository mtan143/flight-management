package com.flightmanagement.flightmanagement.payment;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChargeResponse {

    private String name;
    private String chargeId;
    private int amount;
}

package com.flightmanagement.flightmanagement.payment;
import com.stripe.param.issuing.CardholderCreateParams;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CardHolder {

    private String name;
    private String email;
    private String phoneNumber;
    private CardholderCreateParams.Status status;
    private CardholderCreateParams.Type type;
    private String line;
    private String city;
    private String state;
    private String postalCode;
    private String country;
}

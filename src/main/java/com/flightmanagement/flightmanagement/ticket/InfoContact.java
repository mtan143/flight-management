package com.flightmanagement.flightmanagement.ticket;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InfoContact {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
}

package com.flightmanagement.flightmanagement.ticket;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {

    @JsonProperty("MESSAGE")
    private String MESSAGE;
    @JsonProperty("STATUS")
    private String STATUS;
    @JsonProperty("HISTORY_TRANSACTION_ID")
    private String HISTORY_TRANSACTION_ID;
}

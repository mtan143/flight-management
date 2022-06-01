package com.flightmanagement.flightmanagement.account;

import com.flightmanagement.flightmanagement.airline.Airline;
import com.flightmanagement.flightmanagement.airline.AirlineError;
import com.flightmanagement.flightmanagement.exception.BusinessException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@UtilityClass
@Slf4j
public class AccountValidator {

    public void validate (Account account) {

        if (Objects.isNull(account)) {
            log.info("Execute this method got error due to empty airline");
            throw new BusinessException(AccountError.AIRLINE_ID);
        }

        if (account.getPartnerId() == null) {
            log.info("Execute this method got error due to empty partner id");
            throw new BusinessException(AccountError.PARTNER_ID_EMPTY);
        }

        if (account.getAirlineCode() == null) {
            log.info("Execute this method got error due to empty airline code");
            throw new BusinessException(AccountError.AIRLINE_CODE_EMPTY);
        }


    }

}

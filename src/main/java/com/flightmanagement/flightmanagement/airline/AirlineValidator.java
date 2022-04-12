package com.flightmanagement.flightmanagement.airline;

import com.flightmanagement.flightmanagement.exception.BusinessException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@UtilityClass
@Slf4j
public class AirlineValidator {

    public void validate (Airline airline) {

        if (Objects.isNull(airline)) {
            log.info("Execute this method got error due to empty airline");
            throw new BusinessException(AirlineError.AIRLINE_INVALID);
        }

        if (airline.getName().isEmpty()) {
            log.info("Execute this method got error due to empty name");
            throw new BusinessException(AirlineError.NAME_EMPTY);
        }


    }

}

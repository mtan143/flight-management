package com.flightmanagement.flightmanagement.passenger;
import com.flightmanagement.flightmanagement.exception.BusinessException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@UtilityClass
@Slf4j
public class PassengerValidator {

    public void validate (Passenger passenger) {

        if (Objects.isNull(passenger)) {
            log.info("Execute this method got error due to empty passenger");
            throw new BusinessException(PassengerError.PASSENGER_INVALID);
        }

        if (passenger.getTicketId() < 0) {
            log.info("Execute this method got error due to empty ticket id");
            throw new BusinessException(PassengerError.TICKET_ID_INVALID);
        }

        if (passenger.getFirstName().isEmpty()) {
            log.info("Execute this method got error due to empty firstname");
            throw new BusinessException(PassengerError.FIRSTNAME_EMPTY);
        }

        if (passenger.getLastName().isEmpty()) {
            log.info("Execute this method got error due to empty lastname");
            throw new BusinessException(PassengerError.LASTNAME_EMPTY);
        }

    }

}

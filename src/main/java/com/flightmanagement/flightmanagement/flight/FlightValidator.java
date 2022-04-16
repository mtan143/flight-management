package com.flightmanagement.flightmanagement.flight;
import com.flightmanagement.flightmanagement.exception.BusinessException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@UtilityClass
@Slf4j
public class FlightValidator {

    public void validate (Flight flight) {

        if (Objects.isNull(flight)) {
            log.info("Execute this method got error due to empty flight");
            throw new BusinessException(FlightError.FLIGHT_INVALID);
        }

        if (flight.getFlightCode().isEmpty()) {
            log.info("Execute this method got error due to empty flight code");
            throw new BusinessException(FlightError.FLIGHT_CODE_EMPTY);
        }

        if (flight.getAirlineId() < 0) {
            log.info("Execute this method got error due to empty airline id");
            throw new BusinessException(FlightError.AIRLINE_ID_EMPTY);
        }

        if (flight.getGateId().isEmpty()) {
            log.info("Execute this method got error due to empty gate id");
            throw new BusinessException(FlightError.GATE_EMPTY);
        }

    }

}

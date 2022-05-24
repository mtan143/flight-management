package com.flightmanagement.flightmanagement.ticket;
import com.flightmanagement.flightmanagement.exception.BusinessException;
import com.flightmanagement.flightmanagement.passenger.Passenger;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@UtilityClass
@Slf4j
public class TicketValidator {

    public void validate (Ticket ticket) {

        if (Objects.isNull(ticket)) {
            log.info("Execute this method got error due to empty ticket");
            throw new BusinessException(TicketError.TICKET_INVALID);
        }

        if (ticket.getTicketCode().isEmpty()) {
            log.info("Execute this method got error due to empty ticket code");
            throw new BusinessException(TicketError.TICKET_CODE_INVALID);
        }

        if (ticket.getChargeId().isEmpty()) {
            log.info("Execute this method got error due to empty ticket code");
            throw new BusinessException(TicketError.CHARGE_NOT_EXIST);
        }

        if (ticket.getClassFlightId() < 0) {
            log.info("Execute this method got error due to invalid class flight code");
            throw new BusinessException(TicketError.CLASS_FLIGHT_INVALID);
        }

        if (ticket.getFirstName().isEmpty()) {
            log.info("Execute this method got error due to empty firstname");
            throw new BusinessException(TicketError.FIRSTNAME_EMPTY);
        }

        if (ticket.getLastName().isEmpty()) {
            log.info("Execute this method got error due to empty lastname");
            throw new BusinessException(TicketError.LASTNAME_EMPTY);
        }

        if (ticket.getPhoneNumber().isEmpty()) {
            log.info("Execute this method got error due to empty phone number");
            throw new BusinessException(TicketError.PHONE_NUMBER_INVALID);
        }

        if (ticket.getEmail().isEmpty()) {
            log.info("Execute this method got error due to empty email");
            throw new BusinessException(TicketError.EMAIL_INVALID);
        }
        if (ticket.getTotalPrice() <= 0) {
            log.info("Execute this method got error due to invalid price");
            throw new BusinessException(TicketError.PRICE_INVALID);
        }

    }

}

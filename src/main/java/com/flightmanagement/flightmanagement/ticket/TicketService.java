package com.flightmanagement.flightmanagement.ticket;

import com.flightmanagement.flightmanagement.common.Response;
import com.flightmanagement.flightmanagement.exception.BusinessException;
import com.flightmanagement.flightmanagement.flight.FlightRepository;
import com.flightmanagement.flightmanagement.flight.classtype.ClassFlightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static com.flightmanagement.flightmanagement.ticket.Status.ACTIVE;
import static com.flightmanagement.flightmanagement.ticket.Status.DISABLED;

@Service
@Slf4j
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private ClassFlightService classFlightService;
    @Autowired
    private FlightRepository flightRepository;

    /**
     * Get all ticket data from database
     * @return
     */
    public Response getAll() {
        log.info("Get all ticket from database...");
        return Response.ok(ticketRepository.findAll());
    }

    /**
     * Get ticket by code
     * @param ticketCode
     */
    public Response findByCode(String ticketCode) {
        log.info("Execute getByCode method from Ticket Service");

        Ticket result = ticketRepository.findBy(ticketCode);

        return result != null ? Response.ok(result)
                : Response.failed(new BusinessException(TicketError.TICKET_NOT_EXIST));
    }

    /**
     * Insert new ticket object to database
     * @param ticket
     * @return
     */
    public Response save(Ticket ticket) {
        log.info("Execute save method from Ticket Service");

        TicketValidator.validate(ticket);
        ticket.setStatus(ACTIVE);
        ticket.setTicketStatus(TicketStatus.Da_Dat);
        ticket.setCreatedBy("SYSTEM");
        ticket.setLastUpdateBy("SYSTEM");
        ticket.setCreatedDate(Date.from(Instant.now()));
        ticket.setLastUpdateDate(Date.from(Instant.now()));
        // Send price transaction to Profile App
        if (ticket.getUserId() != null) {
//            sendTransaction(String AppId, Integer userId, ticket.getTotalPrice())
        }
        ticketRepository.save(ticket);
        classFlightService.updateRemainingTicket(ticket.getClassFlightId());

        return Response.ok();
    }

    /**
     * Update existing ticket in database
     * @param ticket
     * @param id
     * @return
     */
    public Response save(Ticket ticket, Integer id) {

        log.info("Execute update method from Ticket Service");

        Ticket existTicket = ticketRepository.findById(id).get();

        if (Objects.isNull(existTicket)) {
            throw new BusinessException(TicketError.TICKET_NOT_EXIST);
        }

        TicketValidator.validate(ticket);

        // setting new data for existing object
        existTicket.setTicketCode(ticket.getTicketCode());
        existTicket.setClassFlightId(ticket.getClassFlightId());
        existTicket.setFirstName(ticket.getFirstName());
        existTicket.setLastName(ticket.getLastName());
        existTicket.setEmail(ticket.getEmail());
        existTicket.setPhoneNumber(ticket.getPhoneNumber());
        existTicket.setVoucherCode(ticket.getVoucherCode());
        existTicket.setTicketStatus(ticket.getTicketStatus());
        existTicket.setLastUpdateBy("ADMIN");
        existTicket.setLastUpdateDate(Date.from(Instant.now()));

        return Response.ok(this.save(existTicket));
    }

    /**
     * Delete ticket by id
     * @param id
     * @return
     */
    public Response delete(Integer id) {
        log.info("Execute delete method from Ticket Service");

        Ticket existingTicket = ticketRepository.findById(id).get();

        if (Objects.isNull(existingTicket))
            throw new BusinessException(TicketError.TICKET_NOT_EXIST);

        existingTicket.setStatus(DISABLED);
        existingTicket.setLastUpdateBy("ADMIN");
        existingTicket.setLastUpdateDate(Date.from(Instant.now()));

        ticketRepository.save(existingTicket);
        return Response.ok("Deleted ticket object: " + existingTicket.getTicketCode());
    }

    /**
     * Get ticket by id
     * @param id
     * @return
     */
    public Response get(Integer id) {
        log.info("Execute get method from Ticket Service");

        Ticket ticket = ticketRepository.findById(id).get();

        if (Objects.isNull(ticket)) {
            throw new BusinessException(TicketError.TICKET_NOT_EXIST);
        }

        return Response.ok(ticket);
    }

    /**
     * Retrieve all user's transaction by email
     * @param email
     * @return
     */
//    public Response historyTransaction(String email) {
//
//        List<Ticket> tickets = ticketRepository.historyTransaction(email);
//
//        tickets.stream().map(t ->
//                new Transaction(t.getTicketId(), t.getCreatedDate(),
//                        t.getTicketCode(), t.getTotalPrice(), t.getTicketStatus(),
//                        flightRepository.getByTicketCode(t.getTicketCode()).getDeparturePlace(),
//                        flightRepository.getByTicketCode(t.getTicketCode()).getDestination()));
//        return Response.ok(tickets);
//    }

    /**
     * Get all ticket by flight code
     * @param flightCode
     * @return
     */
    public Response getByFlightCode(String flightCode) {
        return Response.ok(ticketRepository.getByFlightCode(flightCode));
    }

    /**
     * Get total price of user's transaction to save coupon
     * @param userId
     * @return
     */
    public Response getPriceTransaction(Integer userId) {
        return Response.ok(ticketRepository.getPriceTransaction(userId));
    }

//    public Response cancelTicket() {
//
//    }

//    public Response refund() {
//
//    }

}

package com.flightmanagement.flightmanagement.ticket;

import com.flightmanagement.flightmanagement.common.Response;
import com.flightmanagement.flightmanagement.exception.BusinessException;
import com.flightmanagement.flightmanagement.flight.Flight;
import com.flightmanagement.flightmanagement.flight.FlightService;
import com.flightmanagement.flightmanagement.flight.ResultFlight;
import com.flightmanagement.flightmanagement.flight.classtype.ClassFlightManage;
import com.flightmanagement.flightmanagement.flight.classtype.ClassFlightRepository;
import com.flightmanagement.flightmanagement.flight.classtype.ClassFlightService;
import com.flightmanagement.flightmanagement.mail.MailService;
import com.flightmanagement.flightmanagement.passenger.Passenger;
import com.flightmanagement.flightmanagement.passenger.PassengerRepository;
import com.flightmanagement.flightmanagement.passenger.PassengerValidator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

import static com.flightmanagement.flightmanagement.ticket.Status.ACTIVE;
import static com.flightmanagement.flightmanagement.ticket.Status.DISABLED;
import static com.flightmanagement.flightmanagement.ticket.TicketStatus.Da_Dat;

@Service
@Slf4j
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ClassFlightService classFlightService;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private ClassFlightRepository classFlightRepository;

    @Autowired
    private MailService mailService;

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
        ticket.setTicketStatus(Da_Dat);
        ticket.setCreatedBy("SYSTEM");
        ticket.setLastUpdateBy("SYSTEM");
        ticket.setCreatedDate(Date.from(Instant.now()));
        ticket.setLastUpdateDate(Date.from(Instant.now()));
        ticket.setNew(true);
        // Send price transaction to Profile App
        if (ticket.getUserId() != null) {
//            sendTransaction(String AppId, Integer userId, ticket.getTotalPrice())
        }
        ticketRepository.save(ticket);
        classFlightService.updateRemainingTicket(ticket.getClassFlightId());

        return Response.ok(ticket);
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

    /**
     * Create new ticket item
     * @param ticketItem
     * @return
     */
    public Response create(TicketItem ticketItem) {

        Ticket ticket = new Ticket("newFlight", ticketItem.getClassFlightId(), ticketItem.getUserId(), ticketItem.getFirstName(),
                ticketItem.getLastName(), ticketItem.getPhoneNumber(), ticketItem.getEmail(), ticketItem.getTotalPrice(),
                ticketItem.getVoucherCode(), ticketItem.getGiftCode());
        TicketValidator.validate(ticket);
        ticketRepository.save(ticket);
        ClassFlightManage classType = classFlightRepository.findById(ticket.getClassFlightId()).get();
        classType.setRemainingQuantity(classType.getRemainingQuantity() - ticketItem.getPassengers().size());
        classFlightRepository.save(classType);

        Ticket tk = ticketRepository.findBy("newFlight");
        String code = ticketRepository.getAirlineCodeByClassFlightId(ticket.getClassFlightId()).substring(8, 12)
                        .concat(String.format("%04d", ticketItem.getClassFlightId()))
                        .concat(String.format("%04d", tk.getTicketId()));
        tk.setTicketCode(code);
        tk.setTicketStatus(Da_Dat);
        ticketRepository.save(tk);

        ticketItem.getPassengers().forEach(p -> {
            Passenger passenger = new Passenger(tk.getTicketId(), p.getAppellation(), p.getFirstName(),
                    p.getLastName(), p.getDateOfBirth(), p.getNationality());
            System.out.println(passenger);
            PassengerValidator.validate(passenger);
            passengerRepository.save(passenger);
        });



        return Response.ok(tk.getTicketCode());
    }

    public String getFlightNameByTicketId(Integer ticketId) {

        String flight = ticketRepository.getFlightNameByTicketId(ticketId);
        return flight.isEmpty() ? "" : flight;
    }

    public String getTimeDepartureByTicketId(Integer ticketId) {

        String flight = ticketRepository.getTimeDepartureByTicketId(ticketId);
        return flight.isEmpty() ? "" : flight;
    }

    public String getTimeArrivalByTicketId(Integer ticketId) {

        String flight = ticketRepository.getTimeArrivalByTicketId(ticketId);
        return flight.isEmpty() ? "" : flight;
    }

    public String getAirlineNameByTicketId(Integer ticketId) {

        String airlineName = ticketRepository.getAirlineNameByTicketId(ticketId);
        return airlineName.isEmpty() ? "" : airlineName;
    }


    public Response sendEmail() throws MessagingException {

        Ticket ticket = ticketRepository.findBy("CDVN00010016");
        if (ticket == null) return Response.failed(new BusinessException(TicketError.TICKET_NOT_EXIST));

        try {
            mailService.confirmTicket(ticket.getFirstName().concat(" ").concat(ticket.getLastName()),
                    this.getFlightNameByTicketId(ticket.getTicketId()), ticket.getTicketCode(),
                    this.getTimeDepartureByTicketId(ticket.getTicketId()), getTimeArrivalByTicketId(ticket.getTicketId()),
                    getAirlineNameByTicketId(ticket.getTicketId()), ticket.getTotalPrice());
        } catch (MessagingException e) {
            return Response.failed(new BusinessException("404", e.getMessage()));
        }

        return Response.ok("Check your mail!");
    }

}

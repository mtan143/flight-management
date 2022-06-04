package com.flightmanagement.flightmanagement.ticket;

import com.flightmanagement.flightmanagement.account.AccountService;
import com.flightmanagement.flightmanagement.airline.AirlineService;
import com.flightmanagement.flightmanagement.common.Response;
import com.flightmanagement.flightmanagement.exception.BaseError;
import com.flightmanagement.flightmanagement.exception.BusinessException;
import com.flightmanagement.flightmanagement.flight.Flight;
import com.flightmanagement.flightmanagement.flight.FlightError;
import com.flightmanagement.flightmanagement.flight.FlightService;
import com.flightmanagement.flightmanagement.flight.classtype.ClassFlightManage;
import com.flightmanagement.flightmanagement.flight.classtype.ClassFlightRepository;
import com.flightmanagement.flightmanagement.flight.classtype.ClassFlightService;
import com.flightmanagement.flightmanagement.mail.MailService;
import com.flightmanagement.flightmanagement.passenger.Passenger;
import com.flightmanagement.flightmanagement.passenger.PassengerRepository;
import com.flightmanagement.flightmanagement.passenger.PassengerService;
import com.flightmanagement.flightmanagement.passenger.PassengerValidator;
import com.flightmanagement.flightmanagement.payment.PaymentService;
import com.stripe.exception.StripeException;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.mail.MessagingException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static com.flightmanagement.flightmanagement.ticket.Status.ACTIVE;
import static com.flightmanagement.flightmanagement.ticket.TicketStatus.Da_Dat;
import static com.flightmanagement.flightmanagement.ticket.TicketStatus.Da_Huy;

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

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private FlightService flightService;

    @Autowired
    private AirlineService airlineService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private RestTemplate restTemplate;

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


    public Response cancelTicket(Integer ticketId, String token) throws StripeException {

        //retrieve and validate ticket
        Ticket ticket = ticketRepository.findById(ticketId).get();
        if (ticket == null) return Response.failed(new BusinessException(TicketError.TICKET_NOT_EXIST));

        //send refund transaction to Profile Service
        //get flight info of ticket
        Flight flight = flightService.getFlightByTicketCode(ticket.getTicketCode());
        if (flight == null) return Response.failed(new BusinessException(FlightError.FLIGHT_NOT_EXIST));

        //get partnerId from airlineCode of current ticket
        String partnerId = accountService.getPartnerIdByAirlineCode(airlineService.findByAirlineId(flight.getAirlineId()));

        if (partnerId == null) return Response.failed(new BusinessException(TicketError.PARTNER_ID_NOT_FOUND));

        TransactionResponse response;

        try {
            response = this.refundTransaction(token, partnerId, ticket.getTransactionId());

            log.info(response.getMESSAGE());
            if (!response.getSTATUS().equals("true"))
                return Response.failed(new BusinessException(new BaseError() {
                @Override
                public String getCode() {
                    return "REFUND_ERROR";
                }
                @Override
                public String getMessage() {
                    return response.getMESSAGE();
                }
            }));

        } catch (Exception e) {
            log.warn(e.getMessage());
            return Response.failed(new BusinessException(TicketError.REFUND_FAILED));
        }

        paymentService.refund(ticket.getChargeId());

        ticket.setTicketStatus(Da_Huy);

        ClassFlightManage classType = classFlightRepository.findById(ticket.getClassFlightId()).get();
        classType.setRemainingQuantity(classType.getRemainingQuantity() + ticketRepository.getPassengersCount(ticketId));
        classFlightRepository.save(classType);
        ticketRepository.save(ticket);

        return Response.ok("Cancel Success");
    }


    /**
     * Create new ticket item
     * @param ticketItem
     * @return
     */
    public Response create(TicketItem ticketItem) throws JSONException {

        //get classFlightId from classFlightCode in TicketItem Object to new Ticket
        int classFlightId = classFlightRepository.findByCode(ticketItem.getClassFlightCode());

        //create Ticket Object
        Ticket ticket = new Ticket("newFlight", classFlightId, ticketItem.getUserId(), ticketItem.getFirstName(),
                ticketItem.getLastName(), ticketItem.getPhoneNumber(), ticketItem.getEmail(), ticketItem.getTotalPrice(),
                ticketItem.getVoucherCode(), ticketItem.getGiftCode(), ticketItem.getChargeId());


        //validate ticket
        TicketValidator.validate(ticket);

        //save ticket if valid
        ticketRepository.save(ticket);

        //update remaining quantity of a class type
        ClassFlightManage classType = classFlightRepository.findById(ticket.getClassFlightId()).get();
        classType.setRemainingQuantity(classType.getRemainingQuantity() - ticketItem.getPassengers().size());
        classFlightRepository.save(classType);

        Ticket tk = ticketRepository.findBy("newFlight");

        //create flight code
        String code = ticketRepository.getAirlineCodeByClassFlightId(ticket.getClassFlightId()).substring(8, 12)
                        .concat(String.format("%04d", classFlightId))
                        .concat(String.format("%04d", tk.getTicketId()));
        tk.setTicketCode(code);
        tk.setTicketStatus(Da_Dat);
        ticketRepository.save(tk);

        //create list passengers from TicketItem
        ticketItem.getPassengers().forEach(p -> {
            Passenger passenger = new Passenger(tk.getTicketId(), p.getAppellation(), p.getFirstName(),
                    p.getLastName(), p.getDateOfBirth(), p.getNationality());
            System.out.println(passenger);
            PassengerValidator.validate(passenger);
            passengerRepository.save(passenger);
        });

        //send information email to customer
        sendEmail(code);

        //send transaction value to Profile Service
        //get flight info of ticket
        Flight flight = flightService.getFlightByTicketCode(tk.getTicketCode());

        //get partnerId from airlineCode of current ticket
        String partnerId = accountService.getPartnerIdByAirlineCode(airlineService.findByAirlineId(flight.getAirlineId()));

        if (partnerId == null) return Response.failed(new BusinessException(TicketError.PARTNER_ID_NOT_FOUND));

        TransactionResponse response;

        try {
            response = this.checkTransaction(ticketItem.getToken(),
                    new SimpleDateFormat("yyyy-MM-dd").format(flight.getDeparture()),
                    tk.getTotalPrice(), new SimpleDateFormat("yyyy-MM-dd").format(tk.getCreatedDate()),
                    partnerId, code
            );

            tk.setTransactionId(response.getHISTORY_TRANSACTION_ID());
            ticketRepository.save(tk);

        } catch (Exception e) {
            log.warn(e.getMessage());
            return Response.failed(new BusinessException(TicketError.TRANSACTION_FAILED));
        }

        return Response.ok(tk.getTicketCode().isEmpty() ? "" : tk.getTicketCode());
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

    public void sendEmail(String ticketCode) {

        Ticket ticket = ticketRepository.findBy(ticketCode);
        if (ticket == null) throw new  BusinessException(TicketError.TICKET_NOT_EXIST);

        try {
            mailService.confirmTicket(ticket.getFirstName().concat(" ").concat(ticket.getLastName()),
                    this.getFlightNameByTicketId(ticket.getTicketId()), ticket.getTicketCode(),
                    this.getTimeDepartureByTicketId(ticket.getTicketId()), getTimeArrivalByTicketId(ticket.getTicketId()),
                    getAirlineNameByTicketId(ticket.getTicketId()), ticket.getTotalPrice(), ticket.getEmail());
        } catch (MessagingException e) {
            throw new  BusinessException("404", e.getMessage());
        }
    }

    public List<TicketResponse> findByUserId(String userId) {

        List<TicketResponse> res = new ArrayList<>();
        List<Ticket> tickets = ticketRepository.findByUserId(userId);
        tickets.forEach(ticket -> res.add(new TicketResponse(ticket,
                passengerService.getPassengersByTicketCode(ticket.getTicketCode()),
                this.getDepartureByTicketId(ticket.getTicketId()))));
        return res;
    }

    public Date getDepartureByTicketId(Integer ticketId) {
        return ticketRepository.getDepartureByTicketId(ticketId);
    }

    public List<Ticket> getTicketByAirlineCode(String airlineCode) {
        return ticketRepository.getTicketByAirlineCode(airlineCode).stream()
                .sorted(Comparator.comparing(Ticket::getCreatedDate)).collect(Collectors.toList());
    }

    /**
     * Send transaction to Profile Service
     * @param token
     * @param endDate
     * @param totalPrice
     * @param dateTransaction
     * @param partnerId
     * @param ticketCode
     * @return
     * @throws JSONException
     */
    public TransactionResponse checkTransaction(String token, String endDate, int totalPrice, String dateTransaction,
                                                String partnerId, String ticketCode) throws JSONException {

        String url = "https://gxyvy04g01backend-production.up.railway.app/Customer/insertTransicationAndPP";

        JSONObject data = new JSONObject();
        data.put("TOKEN", token);
        data.put("END_DATE", endDate);
        data.put("TRANSACTION_VALUE", totalPrice);
        data.put("DATE_TRANSACTION", dateTransaction);
        data.put("APP_ID", "FLIGHT");
        data.put("PARTNER_ID", partnerId.trim());
        data.put("INFO_TRANSACTION", "TRANSACTION FOR TICKET CODE: " + ticketCode);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(data.toString(), headers);

        TransactionResponse response;

        //Serious call to Profile Service
        try {
            response = restTemplate.postForObject(url, entity, TransactionResponse.class);
        }
        catch (Exception e) {
            throw new BusinessException(TicketError.TRANSACTION_FAILED);
        }

        System.out.println(data);
        System.out.println(partnerId);

        return response;
    }


    public TransactionResponse refundTransaction(String token, String partnerId, String transactionId) throws JSONException {

        String url = "https://gxyvy04g01backend-production.up.railway.app/Customer/refundTransicationAndPP";


        JSONObject data = new JSONObject();
        data.put("TOKEN", token);
        data.put("DATE_TRANSACTION", new SimpleDateFormat("yyyy-MM-dd").format(Date.from(Instant.now())));
        data.put("APP_ID", "FLIGHT");
        data.put("PARTNER_ID", partnerId.trim());
        data.put("HISTORY_TRANSACTION_ID", transactionId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(data.toString(), headers);

        TransactionResponse response;

        //Serious call to Profile Service
        try {
            response = restTemplate.postForObject(url, entity, TransactionResponse.class);
        }
        catch (Exception e) {
            throw new BusinessException(TicketError.REFUND_FAILED);
        }

        System.out.println(data);
        System.out.println(partnerId);

        return response;
    }
}
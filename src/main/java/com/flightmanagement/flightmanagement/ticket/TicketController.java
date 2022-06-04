package com.flightmanagement.flightmanagement.ticket;

import com.flightmanagement.flightmanagement.common.Response;
import com.stripe.exception.StripeException;
import lombok.SneakyThrows;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/customers/tickets")
@CrossOrigin
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public Response getAll() {
        return ticketService.getAll();
    }

    @GetMapping("/find")
    public Response findByCode(@RequestParam String ticketCode) {
        return ticketService.findByCode(ticketCode);
    }

    @PostMapping
    public Response save(@RequestBody Ticket ticket) {
        return ticketService.save(ticket);
    }

    @PutMapping("/{id}")
    public Response save(@RequestBody Ticket ticket, @PathVariable Integer id) {
        return ticketService.save(ticket, id);
    }

    @GetMapping("/{id}")
    public Response get(@PathVariable Integer id) {
        return ticketService.get(id);
    }


    @GetMapping("/flights")
    public Response getByFlightCode(@RequestParam String flightCode) {
        return ticketService.getByFlightCode(flightCode);
    }

    @GetMapping("/totalPrice/{userId}")
    public Response getPriceTransaction(@PathVariable Integer userId) {
        return ticketService.getPriceTransaction(userId);
    }

    @PostMapping("/create")
    public Response create(@RequestBody TicketItem item) throws JSONException {
        return ticketService.create(item);
    }

    @GetMapping("/transaction")
    public Response transactionHistory(@RequestParam String userId) {
        return Response.ok(ticketService.findByUserId(userId));
    }

    @GetMapping("/cancel/{ticketId}")
    public Response cancelTicket(@PathVariable Integer ticketId, @RequestHeader String token) throws StripeException {
        return ticketService.cancelTicket(ticketId, token);
    }

    @GetMapping("/departure/{ticketId}")
    public Response getDepartureByTicketId(@PathVariable Integer ticketId) {
        return Response.ok(ticketService.getDepartureByTicketId(ticketId));
    }

    @GetMapping("/transaction-partner/{airlineCode}")
    public Response getTicketByAirlineCode(@PathVariable String airlineCode) {
        return Response.ok(ticketService.getTicketByAirlineCode(airlineCode));
    }

//    @SneakyThrows
//    @GetMapping("/checkTransaction")
//    public Response checkTransaction() {
//        return Response.ok(ticketService.checkTransaction());
//    }
}

package com.flightmanagement.flightmanagement.ticket;

import com.flightmanagement.flightmanagement.common.Response;
import com.flightmanagement.flightmanagement.flight.Flight;
import com.flightmanagement.flightmanagement.flight.ItemSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers/tickets")
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

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable Integer id) {
        return ticketService.delete(id);
    }

    @GetMapping("/{id}")
    public Response get(@PathVariable Integer id) {
        return ticketService.get(id);
    }

    @GetMapping("/history")
    public Response historyTransaction(@RequestBody String email) {
        return ticketService.historyTransaction(email);
    }

    @GetMapping("/flights")
    public Response getByFlightCode(@RequestParam String flightCode) {
        return ticketService.getByFlightCode(flightCode);
    }
}

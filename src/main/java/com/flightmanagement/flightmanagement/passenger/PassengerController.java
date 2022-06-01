package com.flightmanagement.flightmanagement.passenger;

import com.flightmanagement.flightmanagement.common.Response;
import com.flightmanagement.flightmanagement.flight.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers/passengers")
@CrossOrigin
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping
    public Response getAll() {
        return passengerService.getAll();
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable Integer id) {
        return passengerService.findById(id);
    }

    @PostMapping
    public Response save(@RequestBody Passenger passenger) {
        return passengerService.save(passenger);
    }

    @PutMapping("/{id}")
    public Response save(@RequestBody Passenger passenger, @PathVariable Integer id) {
        return passengerService.save(passenger, id);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable Integer id) {
        return passengerService.delete(id);
    }

    @GetMapping("/tickets")
    public Response getPassengersByTicketCode(@RequestHeader String ticketCode) {
        return Response.ok(passengerService.getPassengersByTicketCode(ticketCode));
    }
}

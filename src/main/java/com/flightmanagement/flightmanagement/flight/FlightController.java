package com.flightmanagement.flightmanagement.flight;

import com.flightmanagement.flightmanagement.airline.Airline;
import com.flightmanagement.flightmanagement.common.Response;
import com.flightmanagement.flightmanagement.flight.classtype.ClassFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/customers/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private ClassFlightService classFlightService;

    @GetMapping
    public Response getAll() {
        return flightService.getAll();
    }

    @GetMapping("/{flightCode}")
    public Response findByCode(@PathVariable String flightCode) {
        return flightService.findByCode(flightCode);
    }

    @PostMapping
    public Response save(@RequestBody Flight flight) {
        return flightService.save(flight);
    }

    @PutMapping("/{id}")
    public Response save(@RequestBody Flight flight, @PathVariable Integer id) {
        return flightService.save(flight, id);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable Integer id) {
        return flightService.delete(id);
    }

    @GetMapping("/{id}")
    public Response get(@PathVariable Integer id) {
        return flightService.get(id);
    }

    @GetMapping("/{flightCode}")
    public Response findFlightStatus(@PathVariable String flightCode) {
        return flightService.findFlightStatus(flightCode);
    }

    @GetMapping("/search")
    public Response searchFlight(@RequestBody ItemSearch itemSearch) {
        return flightService.searchFlight(itemSearch);
    }

    /*@GetMapping("/count")
    public Response flightOfDayCounting(@RequestBody LocalDateTime time) {
        return flightService.flightOfDayCounting(time);
    }*/

    @GetMapping("/classTypes/{flightCode}")
    public Response getClassTypeByFlightCode(@PathVariable String flightCode) {
        return classFlightService.findByFlightCode(flightCode);
    }
}

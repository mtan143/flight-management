package com.flightmanagement.flightmanagement.flight;

import com.flightmanagement.flightmanagement.airline.Airline;
import com.flightmanagement.flightmanagement.common.Response;
import com.flightmanagement.flightmanagement.flight.classtype.ClassFlightService;
import com.flightmanagement.flightmanagement.flight.classtype.ClassType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/customers/flights")
@CrossOrigin
public class FlightController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private ClassFlightService classFlightService;

    @GetMapping
    public Response getAll() {
        return flightService.getAll();
    }

    @GetMapping("/find")
    public Response findByCode(@RequestParam String flightCode) {
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

    @GetMapping("/status")
    public Response findFlightStatus(@RequestParam String flightCode) {
        return flightService.findFlightStatus(flightCode);
    }

    @GetMapping("/search")
    public Response searchFlight(@RequestParam String departurePlace, @RequestParam String destination,
                                 @RequestParam int quantity,
                                 @RequestParam ClassType classType, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date departure) {
        return flightService.searchFlight(departurePlace, destination,
                quantity, classType, departure);
    }

    /*@GetMapping("/count")
    public Response flightOfDayCounting(@RequestBody LocalDateTime time) {
        return flightService.flightOfDayCounting(time);
    }*/

    @GetMapping("/classTypes")
    public Response getClassTypeByFlightCode(@RequestParam int flightId) {
        return classFlightService.findByFlightCode(flightId);
    }

}

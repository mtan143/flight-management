package com.flightmanagement.flightmanagement.flight;

import com.flightmanagement.flightmanagement.common.Response;
import com.flightmanagement.flightmanagement.flight.classtype.ClassFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;


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

    @PostMapping("/search")
    public Response searchFlight(@RequestBody SearchItem searchItem) {
        return flightService.searchFlight(searchItem.getDeparturePlace(), searchItem.getDestination(),
                searchItem.getQuantity(), searchItem.getClassType(), new SimpleDateFormat("yyyy-MM-dd").format(searchItem.getDeparture()));
    }


    @GetMapping("/classTypes")
    public Response getClassTypeByFlightCode(@RequestParam int flightId) {
        return classFlightService.findByFlightCode(flightId);
    }

    @PostMapping("/create")
    public Response create(@RequestBody FlightItem flightItem) throws ParseException {
//        System.out.println(flightItem);
        return flightService.create(flightItem.getName(),
                flightItem.getAirlineId(), new SimpleDateFormat("yyyy-MM-dd").format(flightItem.getDeparture()), flightItem.getDeparturePlace(),
                flightItem.getDestination(), flightItem.getTime(), flightItem.getGateId(),
                flightItem.getTimeDeparture(), flightItem.getTimeArrival(),
                flightItem.getPtPrice(), flightItem.getPtQuantity(),
                flightItem.getPt_dbPrice(), flightItem.getPt_dbQuantity(),
                flightItem.getTgPrice(), flightItem.getTgQuantity(), flightItem.getHnPrice(),
                flightItem.getHnQuantity());
    }
    @GetMapping("/active")
    public Response getActiveFlight() {
        return flightService.getActiveFlight();
    }

}

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

    @GetMapping("/airline/{airlineCode}")
    public Response getAll(@PathVariable String airlineCode) {
        return Response.ok(flightService.getAll(airlineCode));
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
        return classFlightService.findByFlightId(flightId);
    }

    @PostMapping("/create")
    public Response create(@RequestBody FlightItem flightItem) throws ParseException {
        System.out.println(flightItem);
        int stdQ = flightItem.getStdQuantity();
        int stdP = flightItem.getStdPrice();
        return flightService.create(flightItem.getName(),
                flightItem.getAirlineCode(), new SimpleDateFormat("yyyy-MM-dd").format(flightItem.getDeparture()), flightItem.getDeparturePlace(),
                flightItem.getDestination(), flightItem.getTime(), flightItem.getGateId(),
                flightItem.getTimeDeparture(), flightItem.getTimeArrival(),
                stdP, stdQ + 150,
                stdP + 100000, stdQ + 100,
                stdP + 200000, stdQ + 50,
                stdP + 500000, stdQ);
    }
//    @GetMapping("/active")
//    public Response getActiveFlight() {
//        return flightService.getActiveFlight();
//    }

    @PostMapping("/status")
    public Response updateFlightStatus(@RequestBody UpdateStatusObject item) {
        return flightService.updateFlightStatus(item.getFlightCode(), item.getFlightStatus());
    }

    @GetMapping("/airline/statistic/{airlineCode}")
    public Response statisticFlight(@PathVariable String airlineCode) {
        return flightService.statisticFlight(airlineCode);
    }

    @GetMapping("/airline/statistic/month/{airlineCode}")
    public Response statisticFlightByMonth(@PathVariable String airlineCode) {
        return flightService.statisticFlightByMonth(airlineCode);
    }


    @GetMapping("/airline/statistic/classtype/{airlineCode}")
    public Response statisticFlightByClassType(@PathVariable String airlineCode) {
        return flightService.statisticFlightByClassType(airlineCode);
    }

}

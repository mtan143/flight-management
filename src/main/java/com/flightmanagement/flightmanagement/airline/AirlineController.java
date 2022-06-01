package com.flightmanagement.flightmanagement.airline;

import com.flightmanagement.flightmanagement.common.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/partner/airline")
@CrossOrigin
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    @GetMapping
    public Response getAll() {
        return airlineService.getAll();
    }

//    @GetMapping("/find")
//    public Response findByCode(@RequestParam String airlineCode) {
//        return airlineService.findByCode(airlineCode);
//    }

    @PostMapping
    public Response save(@RequestBody Airline airline) throws ParseException {
        return airlineService.save(airline.getAirlineCode(), airline.getName(),
                new SimpleDateFormat("yyyy-MM-dd").format(airline.getFoundDate()));
    }

    @PutMapping("/{id}")
    public Response save(@RequestBody Airline airline, @PathVariable Integer id) {
        return airlineService.save(airline, id);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable Integer id) {
        return airlineService.delete(id);
    }

    @GetMapping("/{id}")
    public Response get(@PathVariable Integer id) {
        return airlineService.get(id);
    }


}

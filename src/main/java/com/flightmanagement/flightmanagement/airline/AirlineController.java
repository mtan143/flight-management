package com.flightmanagement.flightmanagement.airline;

import com.flightmanagement.flightmanagement.common.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/partner/airline")
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    @GetMapping
    public Response getAll() {
        return airlineService.getAll();
    }

    @PostMapping("/{airlineCode}")
    public Response findByCode(@PathVariable String airlineCode) {
        return airlineService.findByCode(airlineCode);
    }

    @PostMapping
    public Response save(@RequestBody Airline airline) {
        return airlineService.save(airline);
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

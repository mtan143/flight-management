package com.flightmanagement.flightmanagement.flight;

import com.flightmanagement.flightmanagement.airline.AirlineError;
import com.flightmanagement.flightmanagement.common.Response;
import com.flightmanagement.flightmanagement.exception.BusinessException;
import com.flightmanagement.flightmanagement.flight.classtype.ClassType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    /**
     * Get all flight data from database
     * @return
     */
    public Response getAll() {
        log.info("Get all flight from database...");
        return Response.ok(flightRepository.findAll());
    }

    /**
     * Get airline by code
     * @param flightCode
     */
    public Response findByCode(String flightCode) {
        log.info("Execute getByCode method from Flight Service");

        Flight result = flightRepository.findBy(flightCode);

        return result != null ? Response.ok(result)
                : Response.failed(new BusinessException(FlightError.FLIGHT_NOT_EXIST));
    }

    /**
     * Insert new flight object to database
     * @param flight
     * @return
     */
    public Response save(Flight flight) {
        log.info("Execute save method from Airline Service");

        FlightValidator.validate(flight);
        flight.setStatus(Status.ACTIVE);
        flight.setCreatedBy("SYSTEM");
        flight.setLastUpdateBy("SYSTEM");
        flight.setCreatedDate(Date.from(Instant.now()));
        flight.setLastUpdateDate(Date.from(Instant.now()));

        return Response.ok(flightRepository.save(flight));
    }

    /**
     * Update existing airline in database
     * @param flight
     * @param id
     * @return
     */
    public Response save(Flight flight, Integer id) {

        log.info("Execute update method from Flight Service");

        Flight existFlight = flightRepository.findById(id).get();

        if (Objects.isNull(existFlight)) {
            throw new BusinessException(FlightError.FLIGHT_NOT_EXIST);
        }

        FlightValidator.validate(flight);

        // setting new data for existing object
        existFlight.setName(flight.getName());
        existFlight.setFlightCode(flight.getFlightCode());
        existFlight.setAirlineId(flight.getAirlineId());
        existFlight.setFlightStatus(flight.getFlightStatus());
        existFlight.setDeparture(flight.getDeparture());
        existFlight.setQuantityTicket(flight.getQuantityTicket());
        existFlight.setDeparturePlace(flight.getDeparturePlace());
        existFlight.setDestination(flight.getDestination());
        existFlight.setGateId(flight.getGateId());
        existFlight.setLastUpdateBy("ADMIN");
        existFlight.setLastUpdateDate(Date.from(Instant.now()));

        return Response.ok(this.save(existFlight));
    }

    /**
     * Delete flight by id
     * @param id
     * @return
     */
    public Response delete(Integer id) {
        log.info("Execute delete method from Flight Service");

        Flight existingFlight = flightRepository.findById(id).get();

        if (Objects.isNull(existingFlight))
            throw new BusinessException(FlightError.FLIGHT_NOT_EXIST);

        existingFlight.setStatus(Status.DISABLED);
        existingFlight.setLastUpdateBy("ADMIN");
        existingFlight.setLastUpdateDate(Date.from(Instant.now()));

        flightRepository.save(existingFlight);
        return Response.ok("Deleted flight object: "
                + existingFlight.getAirlineId() + " " + existingFlight.getName());
    }

    /**
     * Get flight by id
     * @param id
     * @return
     */
    public Response get(Integer id) {
        log.info("Execute get method from Airline Service");

        Flight flight = flightRepository.findById(id).get();

        if (Objects.isNull(flight)) {
            throw new BusinessException(FlightError.FLIGHT_NOT_EXIST);
        }

        return Response.ok(flight);
    }

    /**
     * Find status of flight which has code given before
     * @param flightCode
     * @return
     */
    public Response findFlightStatus(String flightCode) {
        log.info("Execute findFlightStatus method from Airline Service");

        Flight flight = flightRepository.findBy(flightCode);

        if (Objects.isNull(flight)) {
            throw new BusinessException(FlightError.FLIGHT_NOT_EXIST);
        }

        return Response.ok(flightRepository.findFlightStatus(flightCode));
    }


    /**
     * Search flight, can be multiple flight
     * @param
     * @return
     */
    public Response searchFlight(String departurePlace, String destination, int quantity,
                                 ClassType classType, Date departure) {

        List<Flight> flights = flightRepository.searchFlight(departurePlace, destination,
                quantity, classType, departure);

        return flights.isEmpty() ? Response.failed(new BusinessException(FlightError.FLIGHT_NOT_FOUND))
                : Response.ok(flights);
    }

    /**
     * Counting number of flight at that day
     * @return
     */
    /*public Response flightOfDayCounting(LocalDateTime time) {
        return Response.ok(flightRepository.flightOfDayCounting(time));
    }*/

}

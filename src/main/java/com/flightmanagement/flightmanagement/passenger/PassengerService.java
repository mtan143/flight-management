package com.flightmanagement.flightmanagement.passenger;

import com.flightmanagement.flightmanagement.airline.AirlineError;
import com.flightmanagement.flightmanagement.common.Response;
import com.flightmanagement.flightmanagement.exception.BusinessException;
import com.flightmanagement.flightmanagement.flight.Flight;
import com.flightmanagement.flightmanagement.flight.FlightError;
import com.flightmanagement.flightmanagement.flight.FlightValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

import static com.flightmanagement.flightmanagement.passenger.Status.ACTIVE;
import static com.flightmanagement.flightmanagement.passenger.Status.DISABLED;

@Service
@Slf4j
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;


    /**
     * Get all passengers data from database
     * @return
     */
    public Response getAll() {
        log.info("Get all passengers from database...");
        return Response.ok(passengerRepository.findAll());
    }

    /**
     * Get passenger by id
     * @param id
     */
    public Response findById(Integer id) {
        log.info("Execute find by Id method from Passenger Service");

        Passenger result = passengerRepository.findById(id).get();

        return result != null ? Response.ok(result)
                : Response.failed(new BusinessException(PassengerError.PASSENGER_NOT_EXIST));
    }

    /**
     * Insert new passenger object to database
     * @param passenger
     * @return
     */
    public Response save(Passenger passenger) {
        log.info("Execute save method from Passenger Service");

        PassengerValidator.validate(passenger);
        passenger.setStatus(ACTIVE);
        passenger.setCreatedBy("SYSTEM");
        passenger.setLastUpdateBy("SYSTEM");
        passenger.setCreatedDate(Date.from(Instant.now()));
        passenger.setLastUpdateDate(Date.from(Instant.now()));

        return Response.ok(passengerRepository.save(passenger));
    }

    /**
     * Update existing passenger in database
     * @param passenger
     * @param id
     * @return
     */
    public Response save(Passenger passenger, Integer id) {

        log.info("Execute update method from Passenger Service");

        Passenger existPassenger = passengerRepository.findById(id).get();

        if (Objects.isNull(existPassenger)) {
            throw new BusinessException(PassengerError.PASSENGER_NOT_EXIST);
        }

        PassengerValidator.validate(passenger);

        // setting new data for existing object
        existPassenger.setTicketId(passenger.getTicketId());
        existPassenger.setAppellation(passenger.getAppellation());
        existPassenger.setFirstName(passenger.getFirstName());
        existPassenger.setLastName(passenger.getLastName());
        existPassenger.setDateOfBirth(passenger.getDateOfBirth());
        existPassenger.setNationality(passenger.getNationality());
        existPassenger.setLastUpdateBy("ADMIN");
        existPassenger.setLastUpdateDate(Date.from(Instant.now()));

        return Response.ok(this.save(existPassenger));
    }

    /**
     * Delete passenger by id
     * @param id
     * @return
     */
    public Response delete(Integer id) {
        log.info("Execute delete method from Passenger Service");

        Passenger existingPassenger = passengerRepository.findById(id).get();

        if (Objects.isNull(existingPassenger))
            throw new BusinessException(PassengerError.PASSENGER_NOT_EXIST);

        existingPassenger.setStatus(DISABLED);
        existingPassenger.setLastUpdateBy("ADMIN");
        existingPassenger.setLastUpdateDate(Date.from(Instant.now()));

        passengerRepository.save(existingPassenger);
        return Response.ok("Deleted passenger object: "
                + existingPassenger.getFirstName() + " " + existingPassenger.getLastName());
    }

}

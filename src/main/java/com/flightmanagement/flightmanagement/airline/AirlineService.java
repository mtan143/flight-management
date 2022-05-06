package com.flightmanagement.flightmanagement.airline;

import com.flightmanagement.flightmanagement.common.Response;
import com.flightmanagement.flightmanagement.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

import static com.flightmanagement.flightmanagement.passenger.PassengerService.GENERAL_ID;

@Service
@Slf4j
public class AirlineService {

    @Autowired
    private AirlineRepository airlineRepository;

    /**
     * Get all airline data from database
     * @return
     */
    public Response getAll() {
        log.info("Execute getAll airline method");
        return Response.ok(airlineRepository.findAll());
    }

    /**
     * Get airline by code
     * @param airlineCode
     */
    public Response findByCode(String airlineCode) {

        log.info("Execute getByCode method from Airline Service");
        if (airlineCode.isEmpty()) throw new BusinessException(AirlineError.AIRLINE_CODE_INVALID);

        Airline result = airlineRepository.findBy(airlineCode);

        return result != null ? Response.ok(result)
                : Response.failed(new BusinessException(AirlineError.AIRLINE_NOT_EXIST));
    }

    /**
     * Insert new airline object to database
     * @param airlineCode
     * @param name
     * @param foundDate
     * @return
     * @throws ParseException
     */
    public Response save(String airlineCode, String name, String foundDate) throws ParseException {
        log.info("Execute save method from Airline Service");

        Airline airline = new Airline();

        airline.setAirlineCode(airlineCode);
        airline.setName(name);
        airline.setFoundDate(new SimpleDateFormat("yyyy-MM-dd").parse(foundDate));

        airline.setAirlineId(GENERAL_ID++);
        airline.setStatus(Status.ACTIVE);
        airline.setCreatedBy("SYSTEM");
        airline.setLastUpdateBy("SYSTEM");
        airline.setCreatedDate(Date.from(Instant.now()));
        airline.setLastUpdateDate(Date.from(Instant.now()));
        airline.setNew(true);

        AirlineValidator.validate(airline);
        return Response.ok(airlineRepository.save(airline));
    }

    /**
     * Update existing airline in database
     * @param airline
     * @param id
     * @return
     */
    public Response save(Airline airline, Integer id) {

        log.info("Execute update method from Airline Service");

        Airline existAirline = airlineRepository.findById(id).get();

        if (Objects.isNull(existAirline)) {
            throw new BusinessException(AirlineError.AIRLINE_NOT_EXIST);
        }

        AirlineValidator.validate(airline);

        // setting new data for existing object
        existAirline.setName(airline.getName());
        existAirline.setFoundDate(airline.getFoundDate());
        existAirline.setLastUpdateBy("ADMIN");
        existAirline.setLastUpdateDate(Date.from(Instant.now()));

        return Response.ok(airlineRepository.save(existAirline));
    }


    /**
     * Delete airline by code
     * @param id
     * @return
     */
    public Response delete(Integer id) {
        log.info("Execute delete method from Airline Service");

        Airline existingAirline = airlineRepository.findById(id).get();

        if (Objects.isNull(existingAirline))
            throw new BusinessException(AirlineError.AIRLINE_NOT_EXIST);

        existingAirline.setStatus(Status.DISABLED);
        existingAirline.setLastUpdateBy("ADMIN");
        existingAirline.setLastUpdateDate(Date.from(Instant.now()));

        airlineRepository.save(existingAirline);
        return Response.ok("Deleted airline object: "
                + existingAirline.getAirlineCode() + " " + existingAirline.getName());
    }

    /**
     * Get airline by id
     * @param id
     * @return
     */
    public Response get(Integer id) {
        log.info("Execute get method from Airline Service");

        Airline airline = airlineRepository.findById(id).get();

        if (Objects.isNull(airline)) {
            throw new BusinessException(AirlineError.AIRLINE_NOT_EXIST);
        }

        return Response.ok(airline);
    }

}

package com.flightmanagement.flightmanagement.flight.classtype;

import com.flightmanagement.flightmanagement.airline.AirlineValidator;
import com.flightmanagement.flightmanagement.common.Response;
import com.flightmanagement.flightmanagement.exception.BusinessException;
import com.flightmanagement.flightmanagement.flight.Flight;
import com.flightmanagement.flightmanagement.flight.FlightError;
import com.flightmanagement.flightmanagement.flight.FlightValidator;
import com.flightmanagement.flightmanagement.flight.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

import static com.flightmanagement.flightmanagement.flight.Status.ACTIVE;

@Service
@Slf4j
public class ClassFlightService {

    @Autowired
    private ClassFlightRepository classFlightRepository;

    /**
     * Create a class type in range which given from Profile
     * @param classFlightManage
     * @return
     */
    public Response save(ClassFlightManage classFlightManage) {
        log.info("Execute save method from ClassFlight Service");

        ClassFlightValidator.validate(classFlightManage);
        classFlightManage.setStatus(ACTIVE);
        classFlightManage.setCreatedBy("SYSTEM");
        classFlightManage.setLastUpdateBy("SYSTEM");
        classFlightManage.setCreatedDate(Date.from(Instant.now()));
        classFlightManage.setLastUpdateDate(Date.from(Instant.now()));

        return Response.ok(classFlightRepository.save(classFlightManage));
    }

    /**
     * Update existing classType in database
     * @param classType
     * @param id
     * @return
     */
    public Response save(ClassFlightManage classType, Integer id) {

        log.info("Execute update method from ClassFLight Service");

        ClassFlightManage existClassType = classFlightRepository.findById(id).get();

        if (Objects.isNull(existClassType)) {
            throw new BusinessException(ClassFlightError.CLASS_FLIGHT_NOT_EXIST);
        }

        ClassFlightValidator.validate(existClassType);

        // setting new data for existing object
        existClassType.setPrice(classType.getPrice());
        existClassType.setQuantity(classType.getQuantity());
        existClassType.setRemainingQuantity(classType.getRemainingQuantity());
        existClassType.setLastUpdateBy("ADMIN");
        existClassType.setLastUpdateDate(Date.from(Instant.now()));

        return Response.ok(this.save(existClassType));
    }

    /**
     * Get barem from Profile App
     */

    /**
     * Update remaining quantity ticket of class flight
     * @param classFlightId
     */
    public void updateRemainingTicket(int classFlightId) {
        int orderedTicket = classFlightRepository.closedTicket(classFlightId);
        ClassFlightManage classFlightManage = classFlightRepository.findById(classFlightId).get();
        classFlightManage.setRemainingQuantity(classFlightManage.getQuantity() - orderedTicket);
        classFlightRepository.save(classFlightManage);
    }

    /**
     * Find all of class flight by flight id
     * @param flightId
     * @return
     */
    public Response findByFlightId(int flightId) {
        return Response.ok(classFlightRepository.findByFlightId(flightId));
    }

}

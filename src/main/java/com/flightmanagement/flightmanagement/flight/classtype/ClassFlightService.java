package com.flightmanagement.flightmanagement.flight.classtype;

import com.flightmanagement.flightmanagement.airline.AirlineValidator;
import com.flightmanagement.flightmanagement.common.Response;
import com.flightmanagement.flightmanagement.flight.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

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
    public Response create(ClassFlightManage classFlightManage) {
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
    public Response findByFlightCode(int flightId) {
        return Response.ok(classFlightRepository.findByFlightId(flightId));
    }

}

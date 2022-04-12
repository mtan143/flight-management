package com.flightmanagement.flightmanagement.flight.classtype;

import com.flightmanagement.flightmanagement.common.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
//    public Response create(ClassFlightManage classFlightManage) {
//
//    }

    /**
     * Get barem from Profile App
     */

    /**
     * Update remaining quantity ticket of class flight
     * @param classFlightCode
     */
    public void updateRemainingTicket(String classFlightCode) {
        int orderedTicket = classFlightRepository.closedTicket(classFlightCode);
        ClassFlightManage classFlightManage = classFlightRepository.findByCode(classFlightCode);
        classFlightManage.setRemainingQuantity(classFlightManage.getQuantity() - orderedTicket);
        classFlightRepository.save(classFlightManage);
    }

    /**
     * Find all of class flight by flight code
     * @param flightCode
     * @return
     */
    public Response findByFlightCode(String flightCode) {
        return Response.ok(classFlightRepository.findByFlightCode(flightCode));
    }

}

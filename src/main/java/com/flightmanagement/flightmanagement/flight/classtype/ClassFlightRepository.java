package com.flightmanagement.flightmanagement.flight.classtype;

import com.flightmanagement.flightmanagement.flight.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassFlightRepository extends JpaRepository<ClassFlightManage, Integer> {

    @Query("select count(t.id) from Ticket t " +
            "inner join ClassFlightManage c on t.classFlightCode=?1 " +
            "where t.ticketStatus='ORDERED'")
    int closedTicket(String classFlightCode);

    @Query("select c from ClassFlightManage c where c.classFlightCode=?1")
    ClassFlightManage findByCode(String classFlightCode);

    @Query("select c from ClassFlightManage c where c.flightCode=?1")
    List<ClassFlightManage> findByFlightCode(String flightCode);
}

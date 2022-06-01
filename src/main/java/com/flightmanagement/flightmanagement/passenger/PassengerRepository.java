package com.flightmanagement.flightmanagement.passenger;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository extends CrudRepository<Passenger, Integer> {

    @Query("select p.* " +
            "from tbl_Passenger as p " +
            "join tbl_Ticket as t on p.ticketId=t.ticketId " +
            "where t.ticketCode=:ticketCode")
    List<Passenger> getPassengersByTicketCode(String ticketCode);
}

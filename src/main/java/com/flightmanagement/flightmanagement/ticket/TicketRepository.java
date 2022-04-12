package com.flightmanagement.flightmanagement.ticket;

import com.flightmanagement.flightmanagement.flight.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    @Query("select a from Ticket a where a.ticketCode=?1")
    Ticket findBy(String ticketCode);

    @Query("select t from Ticket t where t.email=?1")
    List<Ticket> historyTransaction(String email);

    @Query("select t from Ticket t " +
            "inner join ClassFlightManage c on t.classFlightCode=c.classFlightCode " +
            "inner join Flight f on c.flightCode=f.flightCode " +
            "where f.flightCode=?1")
    List<Ticket> getByFlightCode(String flightCode);


}

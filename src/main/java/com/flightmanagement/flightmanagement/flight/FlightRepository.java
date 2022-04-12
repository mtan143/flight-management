package com.flightmanagement.flightmanagement.flight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    @Query("select a from Flight a where a.flightCode=?1")
    Flight findBy(String flightCode);

    @Query("select a.flightStatus from Flight a where a.flightCode=?1")
    FlightStatus findFlightStatus(String flightCode);

    @Query("select a from Flight a " +
            "inner join ClassFlightManage c on a.flightCode=c.flightCode " +
            "where a.departurePlace=:#{#itemSearch.departurePlace} " +
            "and a.destination=:#{#itemSearch.destination} " +
            "and c.classType=:#{#itemSearch.classType} " +
            "and c.remainingQuantity>:#{#itemSearch.quantity} " +
            "and a.departure=:#{#itemSearch.departure}")
    List<Flight> searchFlight(@Param("itemSearch") ItemSearch itemSearch);

    @Query("select f from Flight f " +
            "inner join ClassFlightManage c on c.flightCode=f.flightCode " +
            "inner join Ticket t on t.classFlightCode=c.classFlightCode " +
            "where t.ticketCode=?1")
    Flight getByTicketCode(String ticketCode);

    @Query("select count(f.id) from Flight f where f.departure=?1")
    int flightOfDayCounting(LocalDateTime time);

}

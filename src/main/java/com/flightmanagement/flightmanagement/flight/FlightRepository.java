package com.flightmanagement.flightmanagement.flight;
import com.flightmanagement.flightmanagement.flight.classtype.ClassType;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Integer> {

    @Query("select a from tbl_Flight as a where a.flightCode=:flightCode")
    Flight findBy(@Param("flightCode") String flightCode);

    @Query("select a.flightStatus from tbl_Flight as a where a.flightCode=:flightCode")
    FlightStatus findFlightStatus(@Param("flightCode") String flightCode);

@Query("select * from tbl_Flight as a " +
        "inner join tbl_ClassType as c on a.flightId=c.flightId " +
        "where a.departurePlace=:departurePlace " +
        "and a.destination=:destination " +
        "and c.classType=:classType " +
        "and c.remainingQuantity>:quantity " +
        "and a.departure=:departure")
    List<Flight> searchFlight(@Param("departurePlace") String departurePlace,
                              @Param("destination") String destination,
                              @Param("quantity") int quantity,
                              @Param("classType") ClassType classType,
                              @Param("departure") @DateTimeFormat(pattern = "yyyy-MM-dd") Date departure);

    @Query("select * from tbl_Flight as f " +
            "inner join tbl_ClassType as c on c.flightCode=f.flightCode " +
            "inner join tbl_Ticket t on t.classFlightCode=c.classFlightCode " +
            "where t.ticketCode=:ticketCode")
    Flight getByTicketCode(@Param("ticketCode") String ticketCode);

    @Query("select count(*) from tbl_Flight as f where f.departure=:time")
    int flightOfDayCounting(@Param("time") Date time);

}

package com.flightmanagement.flightmanagement.flight;
import com.flightmanagement.flightmanagement.common.SearchObject;
import com.flightmanagement.flightmanagement.flight.classtype.ClassType;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Integer> {

    @Query("select * from tbl_Flight as a where a.flightCode=:flightCode")
    Flight findBy(@Param("flightCode") String flightCode);

    @Query("select a.flightStatus from tbl_Flight as a where a.flightCode=:flightCode")
    FlightStatus findFlightStatus(@Param("flightCode") String flightCode);


@Query(value = "select a.flightId as flight_id, a.flightCode as flight_code, a.name as flight_name, l.name as airline_name, a.flightStatus as flight_status, a.departure as departure, a.[time] as time, a.timeDeparture as time_departure, a.timeArrival as time_arrival, a.gateId as gate_id, c.price as price " +
        "from tbl_Flight as a " +
        "join tbl_ClassType as c on a.flightId=c.flightId " +
        "join tbl_Airline as l on a.airlineId=l.airlineId " +
        "where a.departurePlace=:departurePlace " +
        "and a.destination=:destination " +
        "and c.classType=:classType " +
        "and c.remainingQuantity>:quantity " +
        "and a.departure=:departure " +
        "and a.flightStatus='Khoi_Tao'")
    List<SearchObject> searchFlight(@Param("departurePlace") String departurePlace,
                                    @Param("destination") String destination,
                                    @Param("quantity") int quantity,
                                    @Param("classType") ClassType classType,
                                    @Param("departure") String departure);



    @Query("select f.flightId from tbl_Flight as f " +
            "inner join tbl_ClassType as c on c.flightCode=f.flightCode " +
            "inner join tbl_Ticket t on t.classFlightCode=c.classFlightCode " +
            "where t.ticketCode=:ticketCode")
    Flight getByTicketCode(@Param("ticketCode") String ticketCode);

    @Query("select count(*) from tbl_Flight as f where f.departure=:time")
    int flightOfDayCounting(@Param("time") Date time);

    @Query("select * from tbl_Flight where tbl_Flight.status='ACTIVE'")
    List<Flight> getActiveFlight();

    @Query("select f.flightId from tbl_Flight as f where f.flightCode=:flightCode")
    Integer getFlightIdByFlightCode(String flightCode);

    @Query("select * from tbl_Flight as f " +
            "left join tbl_Airline as a " +
            "on f.airlineId=a.airlineId " +
            "where a.airlineCode=:airlineCode")
    List<Flight> getFlightByAirlineCode(String airlineCode);

    @Query("select f.* " +
            "from tbl_Flight as f " +
            "join tbl_ClassType as c on f.flightId=c.flightId " +
            "join tbl_Ticket as t on t.classFlightId=c.classFlightId " +
            "where t.ticketCode=:ticketCode")
    Flight getFlightByTicketCode(String ticketCode);

    @Query("select count(*) " +
            "from tbl_Flight as f " +
            "join tbl_Airline as a on a.airlineId=f.airlineId " +
            "where a.airlineCode=:airlineCode")
    int totalFlightByAirlineCode(String airlineCode);
}

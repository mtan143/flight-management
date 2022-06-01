package com.flightmanagement.flightmanagement.passenger;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository extends CrudRepository<Passenger, Integer> {

    @Query("select p.appellation as appellation, p.firstName as first_name, p.lastName as last_name, " +
            "p.dateOfBirth as date_of_birth, p.nationality as nationality, f.flightCode as flight_code, " +
            "a.name as airline_name, f.name as flight_name, f.timeDeparture as time_departure, " +
            "f.timeArrival as time_arrival, t.totalPrice as total_price " +
            "from tbl_Passenger as p " +
            "join tbl_Ticket as t on p.ticketId=t.ticketId " +
            "join tbl_ClassType as c on t.classFlightId=c.classFlightId " +
            "join tbl_Flight as f on c.flightId=f.flightId " +
            "join tbl_Airline as a on f.airlineId=a.airlineId " +
            "where t.ticketCode=:ticketCode")
    List<PassengerItem> getPassengersByTicketCode(String ticketCode);
}

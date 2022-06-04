package com.flightmanagement.flightmanagement.ticket;

import com.flightmanagement.flightmanagement.flight.Flight;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Integer> {

    @Query("select * from tbl_Ticket as a where a.ticketCode=:ticketCode")
    Ticket findBy(@Param("ticketCode") String ticketCode);

    @Query("select t.ticketId, t.ticketCode, t.classFlightId, t.userId, t.firstName, " +
            "t.lastName, t.phoneNumber, t.email, t.ticketStatus, t.totalPrice, " +
            "t.status, t.voucherCode, t.createdBy, t.createdDate, " +
            "t.lastUpdateBy, t.lastUpdateDate " +
            "from tbl_Ticket t " +
            "inner join tbl_ClassType as c on t.classFlightCode=c.classFlightCode " +
            "inner join tbl_Flight as f on c.flightCode=f.flightCode " +
            "where f.flightCode=:flightCode")
    List<Ticket> getByFlightCode(@Param("flightCode") String flightCode);

    @Query("select t.totalPrice from tbl_Ticket as t where t.userId=:userId")
    int getPriceTransaction(@Param("userId") Integer userId);

    @Query("select a.airlineCode from tbl_Airline as a " +
            "join tbl_Flight f on a.airlineId=f.airlineId " +
            "join tbl_ClassType c on f.flightId=c.flightId " +
            "where c.classFlightId=:classFlightId")
    String getAirlineCodeByClassFlightId(int classFlightId);


    @Query("select f.name " +
            "from tbl_Flight as f " +
            "inner join tbl_ClassType as c on f.flightId=c.flightId " +
            "inner join tbl_Ticket as t on c.classFlightId=t.classFlightId " +
            "where t.ticketId=:ticketId")
    String getFlightNameByTicketId(Integer ticketId);


    @Query("select f.timeDeparture " +
            "from tbl_Flight as f " +
            "inner join tbl_ClassType as c on f.flightId=c.flightId " +
            "inner join tbl_Ticket as t on c.classFlightId=t.classFlightId " +
            "where t.ticketId=:ticketId")
    String getTimeDepartureByTicketId(Integer ticketId);

    @Query("select f.timeArrival " +
            "from tbl_Flight as f " +
            "inner join tbl_ClassType as c on f.flightId=c.flightId " +
            "inner join tbl_Ticket as t on c.classFlightId=t.classFlightId " +
            "where t.ticketId=:ticketId")
    String getTimeArrivalByTicketId(Integer ticketId);

    @Query("select a.name " +
            "from tbl_Airline as a " +
            "inner join tbl_Flight as f on a.airlineId=f.airlineId " +
            "inner join tbl_ClassType as c on f.flightId=c.flightId " +
            "inner join tbl_Ticket as t on c.classFlightId=t.classFlightId " +
            "where t.ticketId=:ticketId")
    String getAirlineNameByTicketId(Integer ticketId);

    @Query("select * from tbl_Ticket as t where t.userId=:userId")
    List<Ticket> findByUserId(String userId);

    @Query("select f.departure " +
            "from tbl_Ticket as t " +
            "inner join tbl_ClassType as c on t.classFlightId=c.classFLightId " +
            "inner join tbl_FLight as f on c.flightId=f.flightId " +
            "where t.ticketId=:ticketId")
    Date getDepartureByTicketId(Integer ticketId);

    @Query("select count (*) " +
            "from tbl_Passenger " +
            "where tbl_Passenger.ticketId=:ticketId")
    int getPassengersCount(Integer ticketId);

    @Query("select t.* from tbl_Ticket as t " +
            "inner join tbl_ClassType as c on t.classFlightId=c.classFlightId " +
            "inner join tbl_Flight as f on c.flightId=f.flightId " +
            "inner join tbl_Airline as a on f.airlineId=a.airlineId " +
            "where a.airlineCode=:airlineCode")
    List<Ticket> getTicketByAirlineCode(String airlineCode);

    @Query("select count(*) " +
            "from tbl_Ticket as t " +
            "join tbl_ClassType as c on c.classFlightId=t.classFlightId " +
            "join tbl_Flight as f on c.flightId=f.flightId " +
            "join tbl_Airline as a on f.airlineId=a.airlineId " +
            "where a.airlineCode=:airlineCode")
    int totalTicketByAirlineCode(String airlineCode);

    @Query("select sum(t.totalPrice) " +
            "from tbl_Ticket as t " +
            "join tbl_ClassType as c on c.classFlightId=t.classFlightId " +
            "join tbl_Flight as f on c.flightId=f.flightId " +
            "join tbl_Airline as a on f.airlineId=a.airlineId " +
            "where a.airlineCode=:airlineCode and t.ticketStatus='Da_Dung'")
    int totalPriceByAirlineCode(String airlineCode);
}

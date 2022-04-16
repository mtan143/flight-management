package com.flightmanagement.flightmanagement.ticket;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Integer> {

    @Query("select * from tbl_Ticket as a where a.ticketCode=:ticketCode")
    Ticket findBy(@Param("ticketCode") String ticketCode);

    @Query("select * from tbl_Ticket as t where t.email=:email")
    List<Ticket> historyTransaction(@Param("email") String email);

    @Query("select * from tbl_Ticket t " +
            "inner join tbl_ClassType as c on t.classFlightCode=c.classFlightCode " +
            "inner join tbl_Flight as f on c.flightCode=f.flightCode " +
            "where f.flightCode=:flightCode")
    List<Ticket> getByFlightCode(@Param("flightCode") String flightCode);

    @Query("select t.totalPrice from tbl_Ticket as t where t.userId=:userId")
    int getPriceTransaction(@Param("userId") Integer userId);


}

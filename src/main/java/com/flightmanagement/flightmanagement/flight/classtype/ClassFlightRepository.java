package com.flightmanagement.flightmanagement.flight.classtype;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassFlightRepository extends CrudRepository<ClassFlightManage, Integer> {

    @Query("select count(*) from tbl_Ticket as t " +
            "inner join tbl_ClassType as c on t.classFlightId=:classFlightId " +
            "inner join tbl_Flight as f on f.flightId" +
            "where t.ticketStatus='Tao'")
    int createdTicket(@Param("classFlightId") int classFlightId);

    @Query("select c.classFlightId from tbl_ClassType as c where c.classFlightCode=:classFlightCode")
    int findByCode(@Param("classFlightCode") String classFlightCode);

    @Query("select * from tbl_ClassType as c where c.flightId=:flightId")
    List<ClassFlightManage> findByFlightId(@Param("flightId") int flightId);
}

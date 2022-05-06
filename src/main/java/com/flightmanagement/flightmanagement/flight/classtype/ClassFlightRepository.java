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
            "where t.ticketStatus='Dat_Dat'")
    int closedTicket(@Param("classFlightId") int classFlightId);

    @Query("select * from tbl_ClassType as c where c.classFlightCode=:classFlightCode")
    ClassFlightManage findByCode(@Param("classFlightCode") String classFlightCode);

    @Query("select * from tbl_ClassType as c where c.flightId=:flightId")
    List<ClassFlightManage> findByFlightId(@Param("flightId") int flightId);
}

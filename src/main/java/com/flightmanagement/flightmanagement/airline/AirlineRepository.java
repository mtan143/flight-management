package com.flightmanagement.flightmanagement.airline;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends CrudRepository<Airline, Integer> {

    @Query("select * from tbl_Airline where airlineCode=:airlineCode")
    Airline findBy(@Param("airlineCode") String airlineCode);
}

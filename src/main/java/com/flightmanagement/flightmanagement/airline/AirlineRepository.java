package com.flightmanagement.flightmanagement.airline;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends CrudRepository<Airline, Integer> {

    @Query("select airlineId from tbl_Airline where airlineCode=:airlineCode")
    Integer findBy(@Param("airlineCode") String airlineCode);

    @Query("select a.airlineCode from tbl_Airline as a where a.airlineId=:airlineId")
    String findByAirlineId(Integer airlineId);
}

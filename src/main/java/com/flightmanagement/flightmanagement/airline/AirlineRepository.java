package com.flightmanagement.flightmanagement.airline;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Integer> {

    @Query("select a from Airline a where a.airlineCode=?1")
    Airline findBy(String airlineCode);
}

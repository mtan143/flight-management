package com.flightmanagement.flightmanagement.account;

import com.flightmanagement.flightmanagement.airline.Airline;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {

    @Query("select * " +
            "from tbl_Account as a " +
            "where a.partnerId=:partnerId")
    Account findAccountByPartnerId(String partnerId);


}

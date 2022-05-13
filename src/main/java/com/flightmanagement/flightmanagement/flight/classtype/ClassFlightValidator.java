package com.flightmanagement.flightmanagement.flight.classtype;

import com.flightmanagement.flightmanagement.airline.Airline;
import com.flightmanagement.flightmanagement.airline.AirlineError;
import com.flightmanagement.flightmanagement.exception.BusinessException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

@UtilityClass
@Slf4j
public class ClassFlightValidator {


    public void validate (ClassFlightManage classFlight) {

        if (Objects.isNull(classFlight)) {
            log.info("Execute this method got error due to empty class flight");
            throw new BusinessException(ClassFlightError.CLASS_FLIGHT_INVALID);
        }

        //call api to get barem price (min, max)
//        int min = 0, max = 0;
//        if (classFlight.getPrice() < min && classFlight.getPrice() > max) {
//            log.info("Execute this method got error due to price out of barem");
//            throw new BusinessException(ClassFlightError.PRICE_INVALID);
//        }

        if (classFlight.getRemainingQuantity() > classFlight.getQuantity()) {
            log.info("Execute this method got error due to invalid quantity");
            throw new BusinessException(ClassFlightError.QUANTITY_INVALID);
        }



    }

}

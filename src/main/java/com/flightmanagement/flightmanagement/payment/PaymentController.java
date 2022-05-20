package com.flightmanagement.flightmanagement.payment;

import com.flightmanagement.flightmanagement.common.Response;
import com.flightmanagement.flightmanagement.exception.BusinessException;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Refund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService service;

    @PostMapping
    public Response completePayment(@RequestBody PaymentRequest request) throws StripeException {
        PaymentRequest charge = service.charge(request);
        return charge != null ? Response.ok(charge)
                : Response.failed(new BusinessException(PaymentError.PAYMENT_INVALID));
    }

    @PostMapping("/refund")
    public Response refund(@RequestBody String chargeId) throws StripeException {

        Refund refund = service.refund(chargeId);

        return refund != null ? Response.ok(refund)
                : Response.failed(new BusinessException(PaymentError.REFUND_INVALID));
    }

    @ExceptionHandler
    public String handleError(StripeException ex) {
        return ex.getMessage();
    }
}

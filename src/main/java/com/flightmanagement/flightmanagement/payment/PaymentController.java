package com.flightmanagement.flightmanagement.payment;

import com.flightmanagement.flightmanagement.common.Response;
import com.flightmanagement.flightmanagement.exception.BusinessException;
import com.stripe.exception.StripeException;
import com.stripe.model.Refund;
import com.stripe.model.issuing.Cardholder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService service;

    @PostMapping
    public Response completePayment(@RequestBody PaymentRequest request) throws StripeException {
        ChargeResponse charge = service.charge(request);
        return charge != null ? Response.ok(charge)
                : Response.failed(new BusinessException(PaymentError.PAYMENT_INVALID));
    }

    @PostMapping("/refund")
    public Response refund(@RequestParam String chargeId) throws StripeException {

        Refund refund = service.refund(chargeId);

        return refund != null ? Response.ok(refund)
                : Response.failed(new BusinessException(PaymentError.REFUND_INVALID));
    }


    @PostMapping("/create")
    public Response create(@RequestBody CardHolder cardHolder) throws StripeException {
        Cardholder cardholder = service.create(cardHolder);
        return cardholder != null ? Response.ok(cardholder)
                : Response.failed(new BusinessException(PaymentError.TRANSACTION_INVALID));
    }

    @ExceptionHandler
    public String handleError(StripeException ex) {
        return ex.getMessage();
    }
}

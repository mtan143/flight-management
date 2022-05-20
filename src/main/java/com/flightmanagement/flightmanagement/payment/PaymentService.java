package com.flightmanagement.flightmanagement.payment;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Refund;
import com.stripe.param.RefundCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${STRIPE_SECRET_KEY}")
    private String secretKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
    }

    /**
     * Logic for charge payment
     * @param chargeRequest
     * @return
     * @throws StripeException
     */
    public PaymentRequest charge(PaymentRequest chargeRequest) throws StripeException {
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", chargeRequest.getAmount());
        chargeParams.put("currency", PaymentRequest.Currency.VND);
        chargeParams.put("source", chargeRequest.getToken().getId());
        chargeParams.put("description", chargeRequest.getDescription());

        Charge charge = Charge.create(chargeParams);
        return new PaymentRequest(charge.getDescription(), charge.getAmount().intValue(),
                PaymentRequest.Currency.VND, charge.getReceiptEmail(), chargeRequest.getToken());
    }

    /**
     * Logic for refund Stripe
     * @param chargeId
     * @return
     * @throws StripeException
     */
    public Refund refund(String chargeId) throws StripeException {
        RefundCreateParams params =
                RefundCreateParams.builder().setCharge(chargeId).build();
//        Map<String, Object> params = new HashMap<>();
//        params.put("charge", chargeId);
        Refund rf = Refund.create(params);
        System.out.println(rf.getStatus());
        return rf;
    }
}

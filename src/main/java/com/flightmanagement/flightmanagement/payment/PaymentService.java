package com.flightmanagement.flightmanagement.payment;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Account;
import com.stripe.model.AccountLink;
import com.stripe.model.Charge;
import com.stripe.model.Refund;
import com.stripe.param.AccountCreateParams;
import com.stripe.param.AccountLinkCreateParams;
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
    public ChargeResponse charge(PaymentRequest chargeRequest) throws StripeException {
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", chargeRequest.getAmount());
        chargeParams.put("currency", PaymentRequest.Currency.VND);
        chargeParams.put("source", chargeRequest.getToken().getId());
        chargeParams.put("description", chargeRequest.getDescription());

        Charge charge = Charge.create(chargeParams);
//        return new PaymentRequest(charge.getDescription(), charge.getAmount().intValue(),
//                PaymentRequest.Currency.VND, charge.getReceiptEmail(), chargeRequest.getToken());
        return new ChargeResponse(charge.getBillingDetails().getName(), charge.getId(), charge.getAmount().intValue());
    }

    /**
     * Logic for refund Stripe
     * @param chargeId
     * @return
     * @throws StripeException
     */
    public Refund refund(String chargeId) throws StripeException {
        System.out.println(chargeId);
        RefundCreateParams params = new RefundCreateParams.Builder().setCharge(chargeId).build();
        Refund rf = Refund.create(params);
        System.out.println(rf.getStatus());
        return rf;
    }

    public String createAccount() throws StripeException {
        AccountCreateParams params =
                AccountCreateParams
                        .builder()
                        .setType(AccountCreateParams.Type.EXPRESS)
                        .setEmail("mtan143@icloud.com")
                        .build();

        Account account = Account.create(params);

        AccountLinkCreateParams link =
                AccountLinkCreateParams
                        .builder()
                        .setAccount(account.getId())
                        .setType(AccountLinkCreateParams.Type.CUSTOM_ACCOUNT_VERIFICATION)
                        .build();

        AccountLink accountLink = AccountLink.create(link);
        return account.getId();
    }

}

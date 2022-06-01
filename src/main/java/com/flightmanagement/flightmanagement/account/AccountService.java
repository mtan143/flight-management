package com.flightmanagement.flightmanagement.account;

import com.flightmanagement.flightmanagement.common.Response;
import com.flightmanagement.flightmanagement.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Response create(AccountItem accountItem) {

        if (accountRepository.findAccountByPartnerId(accountItem.getPartnerId()) != null)
            throw new BusinessException(AccountError.ACCOUNT_ALREADY_EXIST);

        Account account = new Account(accountItem.getPartnerId(), accountItem.getAirlineCode(),
                "ADMIN", Date.from(Instant.now()),
                "ADMIN", Date.from(Instant.now()));

        account.setNew(true);
        AccountValidator.validate(account);

        Account acc = new Account();
        try {
            acc = accountRepository.save(account);
        } catch (Exception e) {
            System.err.println(e);
        }

        return Response.ok(acc);

    }

    public Response findByPartnerId(String partnerId) {

        Account account = accountRepository.findAccountByPartnerId(partnerId);

        if (account == null)
            throw new BusinessException(AccountError.ACCOUNT_NOT_EXIST);

        return Response.ok(account);
    }
}

package com.flightmanagement.flightmanagement.account;

import com.flightmanagement.flightmanagement.airline.Statistic;
import com.flightmanagement.flightmanagement.common.Response;
import com.flightmanagement.flightmanagement.exception.BusinessException;
import com.flightmanagement.flightmanagement.flight.FlightService;
import com.flightmanagement.flightmanagement.ticket.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private FlightService flightService;

    @Autowired
    TicketService ticketService;

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

    public String getPartnerIdByAirlineCode(String airlineCode) {
        return accountRepository.getPartnerIdByAirlineCode(airlineCode);
    }

    /**
     * Total statistic for given airline
     * @param airlineCode
     * @return
     */
    public Statistic totalStatistic(String airlineCode) {

        Integer flight = flightService.totalFlightByAirlineCode(airlineCode) != null
                ? flightService.totalFlightByAirlineCode(airlineCode)
                : 0;
        Integer ticket = ticketService.totalTicketByAirlineCode(airlineCode) != null
                ? ticketService.totalTicketByAirlineCode(airlineCode)
                : 0;
        Integer price = ticketService.totalPriceByAirlineCode(airlineCode) != null
                ? ticketService.totalPriceByAirlineCode(airlineCode)
                : 0;

        return new Statistic(flight, ticket, price);

    }
}

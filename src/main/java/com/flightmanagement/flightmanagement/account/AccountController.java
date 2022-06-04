package com.flightmanagement.flightmanagement.account;


import com.flightmanagement.flightmanagement.common.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/partners/account")
@CrossOrigin
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public Response create(@RequestBody AccountItem accountItem) {
        return accountService.create(accountItem);
    }

    @GetMapping("/{partnerId}")
    public Response findByPartnerId(@PathVariable String partnerId) {
        return accountService.findByPartnerId(partnerId);
    }
    @GetMapping("/partner/{airlineCode}")
    public Response getPartnerIdByAirlineCode(@PathVariable String airlineCode) {
        return Response.ok(accountService.getPartnerIdByAirlineCode(airlineCode));
    }
}

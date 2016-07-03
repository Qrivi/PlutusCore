package be.plutus.api.endpoint;

import be.plutus.core.model.account.Account;
import be.plutus.core.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/account" )
public class AccountEndpoint{

    @Autowired
    AccountService accountService;

    @RequestMapping( method = RequestMethod.GET, produces = "application/json" )
    public ResponseEntity<Account> get( Authentication authentication ){
        Account account = accountService.getAccount( (String)authentication.getPrincipal() );
        return new ResponseEntity<>( account, HttpStatus.OK );
    }

}

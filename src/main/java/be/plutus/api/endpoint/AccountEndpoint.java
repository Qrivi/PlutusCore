package be.plutus.api.endpoint;

import be.plutus.core.model.account.Account;
import be.plutus.core.model.token.Token;
import be.plutus.core.service.AccountService;
import be.plutus.core.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping( "/account" )
public class AccountEndpoint{

    @Autowired
    AccountService accountService;

    @Autowired
    TokenService tokenService;

    @PostConstruct
    public void addAccountForTesting(){
        Account account = accountService.getAccount( "davidopdebeeck@hotmail.com" );

        if( account == null )
            accountService.createAccount( "davidopdebeeck@hotmail.com", "this-is-a-password" );
    }

    @RequestMapping( method = RequestMethod.POST, produces = "application/json" )
    public ResponseEntity<Token> post(@RequestHeader( value = "User-Agent", required = false ) String userAgent){
        Account account = accountService.getAccount( "davidopdebeeck@hotmail.com" );
        return new ResponseEntity<>( tokenService.createToken( account, userAgent ), HttpStatus.OK );
    }

    @RequestMapping( method = RequestMethod.GET, produces = "application/json" )
    public ResponseEntity<Account> get(){
        return new ResponseEntity<>( accountService.getAccount( "davidopdebeeck@hotmail.com" ), HttpStatus.OK );
    }

}

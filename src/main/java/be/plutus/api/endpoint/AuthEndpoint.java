package be.plutus.api.endpoint;

import be.plutus.api.response.Response;
import be.plutus.api.response.TokenDTO;
import be.plutus.api.response.meta.DefaultMeta;
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
import java.util.Date;

@RestController
@RequestMapping( "/auth" )
public class AuthEndpoint{

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
    public ResponseEntity<Response<DefaultMeta, TokenDTO>> post( @RequestHeader( value = "User-Agent", required = false ) String userAgent){
        Account account = accountService.getAccount( "davidopdebeeck@hotmail.com" );
        Token token = tokenService.createToken( account, userAgent );

        Response<DefaultMeta, TokenDTO> response = new Response<>();

        DefaultMeta meta = new DefaultMeta();
        meta.setStatusCode( 200 );
        meta.setTimestampRequest( new Date() );

        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setToken( token.getToken() );

        response.setMeta( meta );
        response.setData( tokenDTO );

        return new ResponseEntity<>( response, HttpStatus.OK );
    }
}

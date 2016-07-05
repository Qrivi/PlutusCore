package be.plutus.api.endpoint;

import be.plutus.api.request.AuthenticationDTO;
import be.plutus.api.response.Response;
import be.plutus.api.response.TokenDTO;
import be.plutus.api.response.meta.DefaultMeta;
import be.plutus.api.util.MessageService;
import be.plutus.core.model.account.Account;
import be.plutus.core.model.account.AccountStatus;
import be.plutus.core.model.token.Token;
import be.plutus.core.service.AccountService;
import be.plutus.core.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping(
        path = "/auth",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE )
public class AuthEndpoint{

    @Autowired
    AccountService accountService;

    @Autowired
    TokenService tokenService;

    @Autowired
    MessageService messageService;

    @PostConstruct
    public void addAccountForTesting(){
        Account account = accountService.getAccount( "davidopdebeeck@hotmail.com" );

        if( account == null )
            accountService.createAccount( "davidopdebeeck@hotmail.com", "this-is-a-password" );
    }

    @RequestMapping( method = RequestMethod.POST )
    public ResponseEntity<Response<DefaultMeta, TokenDTO>> post(
            @Valid @RequestBody AuthenticationDTO dto,
            BindingResult bindingResult,
            @RequestHeader( value = "User-Agent", required = false ) String userAgent ){
        Response<DefaultMeta, TokenDTO> response = new Response<>();

        if( bindingResult.hasErrors() ){
            response.setMeta( DefaultMeta.badRequest() );
            response.setErrors( bindingResult.getAllErrors()
                    .stream()
                    .map( DefaultMessageSourceResolvable::getDefaultMessage )
                    .collect( Collectors.toList() )
            );
            return new ResponseEntity<>( response, HttpStatus.BAD_REQUEST );
        }

        Account account = accountService.getAccount( dto.getEmail() );

        if( account == null ){
            response.setMeta( DefaultMeta.badRequest() );
            response.setErrors( messageService.get( "NotValid.AuthEndpoint.email" ) );
            return new ResponseEntity<>( response, HttpStatus.BAD_REQUEST );
        }

        if( !account.isPasswordValid( dto.getPassword() ) ){
            response.setMeta( DefaultMeta.badRequest() );
            response.setErrors( messageService.get( "NotValid.AuthEndpoint.password" ) );
            return new ResponseEntity<>( response, HttpStatus.BAD_REQUEST );
        }

        if( account.getStatus() != AccountStatus.ACTIVE ){
            response.setMeta( DefaultMeta.forbidden() );
            response.setErrors( account.getStatus().getStatus() );
            return new ResponseEntity<>( response, HttpStatus.FORBIDDEN );
        }

        Token token = tokenService.createToken( account, userAgent );

        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setToken( token.getToken() );

        response.setMeta( DefaultMeta.success() );
        response.setData( tokenDTO );

        return new ResponseEntity<>( response, HttpStatus.OK );
    }
}

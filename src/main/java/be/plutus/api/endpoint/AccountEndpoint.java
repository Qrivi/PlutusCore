package be.plutus.api.endpoint;

import be.plutus.api.response.AccountDTO;
import be.plutus.api.response.Response;
import be.plutus.api.response.UserDTO;
import be.plutus.api.response.meta.AccountMeta;
import be.plutus.core.model.account.Account;
import be.plutus.core.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.stream.Collectors;

@RestController
@RequestMapping(
        path = "/account" ,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE )
public class AccountEndpoint{

    @Autowired
    AccountService accountService;

    @RequestMapping( method = RequestMethod.GET )
    public ResponseEntity<Response<AccountMeta, AccountDTO>> get( Authentication authentication ){
        Account account = accountService.getAccount( (String)authentication.getPrincipal() );

        Response<AccountMeta, AccountDTO> response = new Response<>();

        AccountMeta accountMeta = new AccountMeta();
        accountMeta.setEmail( account.getEmail() );
        accountMeta.setStatusCode( 200 );
        accountMeta.setTimestampRequest( new Date() );

        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setEmail( account.getEmail() );
        accountDTO.setUsers( account.getUsers().stream().map( user -> {
            UserDTO userDTO = new UserDTO();
            userDTO.setIndex( account.getUsers().indexOf( user ) );
            userDTO.setFirstName( user.getFirstName() );
            userDTO.setLastName( user.getLastName() );
            userDTO.setInstitution( user.getInstitution() );
            userDTO.setUsername( user.getUsername() );
            return userDTO;
        } ).collect( Collectors.toList() ) );

        response.setMeta( accountMeta );
        response.setData( accountDTO );

        return new ResponseEntity<>( response, HttpStatus.OK );
    }

}

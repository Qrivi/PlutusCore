package be.plutus.api.security.exception;

import org.springframework.security.core.AuthenticationException;

public class AccountNotFoundException extends AuthenticationException{
    public AccountNotFoundException( String msg ){
        super( msg );
    }
}

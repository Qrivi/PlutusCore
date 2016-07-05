package be.plutus.api.security.exception;

import org.springframework.security.core.AuthenticationException;

public class TokenNotFoundException extends AuthenticationException{
    public TokenNotFoundException( String msg ){
        super( msg );
    }
}

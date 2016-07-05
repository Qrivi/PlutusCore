package be.plutus.api.security.exception;

import org.springframework.security.core.AuthenticationException;

public class TokenNotActiveException extends AuthenticationException{
    public TokenNotActiveException( String msg ){
        super( msg );
    }
}

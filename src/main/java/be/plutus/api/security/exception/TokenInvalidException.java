package be.plutus.api.security.exception;

import org.springframework.security.core.AuthenticationException;

public class TokenInvalidException extends AuthenticationException{
    public TokenInvalidException( String msg ){
        super( msg );
    }
}

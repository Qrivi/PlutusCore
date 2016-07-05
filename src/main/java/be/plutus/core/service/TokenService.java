package be.plutus.core.service;

import be.plutus.core.model.account.Account;
import be.plutus.core.model.token.Request;
import be.plutus.core.model.token.Token;

public interface TokenService{

    Token getToken( String token );

    Token createToken( Account account, String userAgent );

    Request createRequest( String endpoint, String method, String ip, Token token );

    void extendToken( Token token );
}

package be.plutus.core.service;

import be.plutus.core.model.account.Account;
import be.plutus.core.model.token.Request;
import be.plutus.core.model.token.Token;

import java.util.Date;

public interface TokenService{

    Token getToken( String token );

    Token createToken( Account account, String userAgent );

    Request createRequest( Token token , String endpoint, String ip );

    void extendToken( Token token );
}

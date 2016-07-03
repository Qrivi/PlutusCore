package be.plutus.core.service;

import be.plutus.core.model.account.Account;
import be.plutus.core.model.token.Token;

public interface TokenService{

    Token getToken( String token );

    Token createToken( Account account, String userAgent );

    void extendToken( Token token );
}

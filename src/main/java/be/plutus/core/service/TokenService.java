package be.plutus.core.service;

import be.plutus.core.model.account.Account;
import be.plutus.core.model.token.Request;
import be.plutus.core.model.token.Token;

import java.util.List;

public interface TokenService{

    Token getToken( String token );

    List<Token> getTokensFromAccount( int id );

    Token createToken( Account account, String applicationName , String device , String requestIp );

    Request createRequest( String endpoint, String method, String ip, Token token );

    void removeToken( int id );

    void extendToken( Token token );
}

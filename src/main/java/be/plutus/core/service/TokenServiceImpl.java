package be.plutus.core.service;

import be.plutus.core.config.Config;
import be.plutus.core.model.account.Account;
import be.plutus.core.model.token.Request;
import be.plutus.core.model.token.Token;
import be.plutus.core.repository.RequestRepository;
import be.plutus.core.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class TokenServiceImpl implements TokenService{

    @Autowired
    TokenRepository tokenRepository;

    @Autowired
    RequestRepository requestRepository;

    @Override
    public Token getToken( String token ){
        return tokenRepository.findByToken( token );
    }

    @Override
    public Token createToken( Account account, String applicationName, String device, String requestIp ){
        Token token = new Token();
        token.setAccount( account );
        token.setToken( UUID.randomUUID().toString() );
        token.setCreatedOn( new Date() );
        token.setExpiryDate( new Date( ( new Date() ).getTime() + Config.DEFAULT_TOKEN_TTL ) );
        token.setApplicationName( applicationName );
        token.setDevice( device );
        token.setRequestIp( requestIp );
        token.setActive( true );
        return tokenRepository.save( token );
    }

    @Override
    public Request createRequest( String endpoint, String method, String ip, Token token ){
        Request request = new Request();
        request.setEndpoint( endpoint );
        request.setMethod( method );
        request.setIp( ip );
        request.setTimestamp( new Date() );
        request.setToken( token );
        return requestRepository.save( request );
    }

    @Override
    public void extendToken( Token token ){
        token.setExpiryDate( new Date( ( new Date() ).getTime() + Config.DEFAULT_TOKEN_TTL ) );
        tokenRepository.save( token );
    }
}

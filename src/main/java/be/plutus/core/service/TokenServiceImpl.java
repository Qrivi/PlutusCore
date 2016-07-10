package be.plutus.core.service;

import be.plutus.core.config.Config;
import be.plutus.core.model.account.Account;
import be.plutus.core.model.token.Request;
import be.plutus.core.model.token.Token;
import be.plutus.core.repository.AccountRepository;
import be.plutus.core.repository.RequestRepository;
import be.plutus.core.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TokenServiceImpl implements TokenService{

    @Autowired
    TokenRepository tokenRepository;

    @Autowired
    RequestRepository requestRepository;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Token getToken( String token ){
        return tokenRepository.findByToken( token );
    }

    @Override
    public List<Token> getTokensFromAccount( int id ){
        Account account = accountRepository.findOne( id );

        if( account == null )
            throw new NullPointerException( "Account with id " + id + " was not found" );

        return tokenRepository.findByAccount( account );
    }

    @Override
    public List<Request> getRequestsFromToken( int id ){
        Token token = tokenRepository.findOne( id );

        if( token == null )
            throw new NullPointerException( "Token with id " + id + " was not found" );

        return requestRepository.findByToken( token );
    }

    @Override
    public Token createToken( Account account, String applicationName, String device, String requestIp ){
        Token token = new Token();
        token.setAccount( account );
        token.setToken( UUID.randomUUID().toString() );
        token.setCreationDate( new Date() );
        token.setExpiryDate( new Date( ( new Date() ).getTime() + Config.DEFAULT_TOKEN_TTL ) );
        token.setApplicationName( applicationName );
        token.setDeviceName( device );
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
    public void deactivateToken( int id ){
        Token token = tokenRepository.findOne( id );

        if( token == null )
            throw new NullPointerException( "Token with id " + id + " was not found" );

        token.setActive( false );

        tokenRepository.save( token );
    }

    @Override
    public void extendToken( Token token ){
        token.setExpiryDate( new Date( ( new Date() ).getTime() + Config.DEFAULT_TOKEN_TTL ) );
        tokenRepository.save( token );
    }
}

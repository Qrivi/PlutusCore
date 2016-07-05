package be.plutus.api.security;

import be.plutus.api.security.exception.*;
import be.plutus.core.model.account.Account;
import be.plutus.core.model.account.AccountStatus;
import be.plutus.core.model.token.Token;
import be.plutus.core.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;

public class TokenAuthenticationFilter extends GenericFilterBean{

    private static String PARAMETER_SECURITY_TOKEN = "token";
    private static String HEADER_SECURITY_TOKEN = "X-Auth-Token";

    private TokenService tokenService;
    private AuthenticationEntryPoint entryPoint;

    public TokenAuthenticationFilter(TokenService tokenService, AuthenticationEntryPoint entryPoint){
        this.tokenService = tokenService;
        this.entryPoint = entryPoint;
    }

    @Override
    public void doFilter( ServletRequest req, ServletResponse res, FilterChain chain ) throws IOException, ServletException{
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)res;
        try{
            String tokenHeader = request.getHeader( HEADER_SECURITY_TOKEN );
            String tokenParameter = request.getParameter( PARAMETER_SECURITY_TOKEN );

            if( SecurityContextHolder.getContext().getAuthentication() == null ){

                Token token = null;

                if( tokenHeader == null && tokenParameter == null )
                    throw new TokenNotFoundException( "TokenNotFoundException" );

                if( tokenHeader != null )
                    token = getToken( tokenHeader );

                if( tokenParameter != null )
                    token = getToken( tokenParameter );

                if( isValid( token ) ){
                    tokenService.extendToken( token );
                    tokenService.createRequest( request.getServletPath(), request.getMethod(), request.getRemoteAddr(), token );

                    Account account = token.getAccount();

                    if( isValid( account ) ){
                        SecurityContextHolder
                                .getContext()
                                .setAuthentication(
                                        new UsernamePasswordAuthenticationToken(
                                                account.getEmail(),
                                                account.getPassword(),
                                                Collections.singletonList( ( () -> "ROLE_BASIC" ) )
                                        )
                                );
                    }
                }
            }

            chain.doFilter( request, response );
        }catch( AuthenticationException e ){
            entryPoint.commence( request, response, e );
        }
    }

    private Token getToken( String tokenString ){
        return tokenService.getToken( tokenString );
    }

    private boolean isValid( Token token ){
        if( token == null )
            throw new TokenInvalidException( "TokenInvalidException" );
        if( !token.isActive() )
            throw new TokenNotActiveException( "TokenNotActiveException" );
        if( token.getExpiryDate().getTime() < new Date().getTime() )
            throw new TokenExpiredException( "TokenExpiredException" );
        return true;
    }

    private boolean isValid( Account account ){
        if( account == null )
            throw new AccountNotFoundException( "AccountNotFoundException" );
        if( account.getStatus() != AccountStatus.ACTIVE )
            throw new AccountNotActiveException( "AccountNotActiveException" );
        return true;
    }
}

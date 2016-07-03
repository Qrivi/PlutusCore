package be.plutus.api.security;

import be.plutus.core.model.account.Account;
import be.plutus.core.model.token.Token;
import be.plutus.core.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;

@Component
public class TokenAuthenticationFilter extends GenericFilterBean{

    private static String PARAMETER_SECURITY_TOKEN = "token";
    private static String HEADER_SECURITY_TOKEN = "X-Auth-Token";

    @Autowired
    TokenService tokenService;

    @Override
    public void doFilter( ServletRequest req, ServletResponse res, FilterChain chain ) throws IOException, ServletException{
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String tokenHeader = request.getHeader( HEADER_SECURITY_TOKEN );
        String tokenParameter = request.getParameter( PARAMETER_SECURITY_TOKEN );

        if ( SecurityContextHolder.getContext().getAuthentication() == null) {

            Token token = null;

            if (tokenHeader != null)
                token = getToken(tokenHeader);

            if (tokenParameter != null)
                token = getToken(tokenParameter);

            if (isValid( token )) {
                tokenService.extendToken( token );
                Account account = token.getAccount();
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

        chain.doFilter(request, response);
    }

    private Token getToken( String tokenString ){
        return tokenService.getToken( tokenString );
    }

    private boolean isValid( Token token ){
        return token != null && token.isActive() && token.getExpiryDate().getTime() > new Date().getTime();
    }

}

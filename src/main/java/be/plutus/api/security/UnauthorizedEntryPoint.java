package be.plutus.api.security;

import be.plutus.api.response.Response;
import be.plutus.api.response.meta.DefaultMeta;
import be.plutus.api.util.MessageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class UnauthorizedEntryPoint implements AuthenticationEntryPoint{

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MessageService messageService;

    @Override
    public void commence( HttpServletRequest req, HttpServletResponse res, AuthenticationException authException ) throws IOException, ServletException{
        Response<DefaultMeta, Object> response = new Response<>();

        response.setMeta( DefaultMeta.unauthorized() );
        response.setErrors( messageService.get( authException.getMessage() ) );

        res.setContentType( "application/json" );
        res.setStatus( HttpServletResponse.SC_UNAUTHORIZED );

        objectMapper.writeValue( res.getOutputStream(), response );
    }
}

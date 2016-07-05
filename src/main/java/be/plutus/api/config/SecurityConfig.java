package be.plutus.api.config;

import be.plutus.api.security.TokenAuthenticationFilter;
import be.plutus.core.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity( debug = true )
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationEntryPoint entryPoint;

    @Override
    public void configure( WebSecurity web ) throws Exception {
        web
            .ignoring()
            .antMatchers( HttpMethod.POST, "/auth" );
    }

    @Override
    protected void configure( HttpSecurity http ) throws Exception{
        http
            .authorizeRequests()
                .anyRequest().fullyAuthenticated()
        .and()
            .addFilterBefore( new TokenAuthenticationFilter( tokenService, entryPoint ), BasicAuthenticationFilter.class )
            .sessionManagement()
            .sessionCreationPolicy( SessionCreationPolicy.STATELESS )
        .and()
            .exceptionHandling()
            .authenticationEntryPoint( entryPoint )
        .and()
            .httpBasic().disable()
            .csrf().disable()
            .anonymous().disable();
    }
}
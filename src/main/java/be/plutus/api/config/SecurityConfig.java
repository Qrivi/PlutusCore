package be.plutus.api.config;

import be.plutus.api.security.TokenAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity( prePostEnabled = true )
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private AuthenticationEntryPoint entryPoint;

    @Autowired
    private TokenAuthenticationFilter tokenAuthenticationFilter;

    @Override
    protected void configure( HttpSecurity http ) throws Exception{
        http
                .authorizeRequests()
                .antMatchers( "/auth" ).permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore( tokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class )
                .sessionManagement()
                .sessionCreationPolicy( SessionCreationPolicy.STATELESS )
                .and()
                .exceptionHandling()
                .authenticationEntryPoint( entryPoint )
                .and()
                .httpBasic().disable()
                .csrf().disable();
    }
}
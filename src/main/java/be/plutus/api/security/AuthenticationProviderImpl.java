package be.plutus.api.security;

import be.plutus.core.model.account.Account;
import be.plutus.core.repository.AccountRepository;
import be.plutus.core.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Component
public class AuthenticationProviderImpl implements AuthenticationManager{

    @Autowired
    AccountService accountService;

    @Override
    public Authentication authenticate( Authentication authentication ) throws AuthenticationException{
        String email = authentication.getName().toLowerCase();
        String password = authentication.getCredentials().toString();

        Account account = accountService.getAccount(email);

        if (authentication.isAuthenticated() || (account != null && account.isPasswordValid(password)))
            return new UsernamePasswordAuthenticationToken(account.getEmail(), account.getPassword(), Collections.singletonList( ( () -> "ROLE_BASIC" ) ) );

        return null;
    }
}

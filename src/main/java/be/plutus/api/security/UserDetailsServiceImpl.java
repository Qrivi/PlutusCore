package be.plutus.api.security;

import be.plutus.core.model.account.Account;
import be.plutus.core.repository.AccountRepository;
import be.plutus.core.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    AccountService accountService;

    @Override
    public UserDetails loadUserByUsername( String email ) throws UsernameNotFoundException{
        Account account = accountService.getAccount(email);

        if (account == null)
            throw new UsernameNotFoundException("Email " + email + " not found");

        return new User(account.getEmail(), account.getPassword(), Collections.singletonList( () -> "ROLE_BASIC" ) );
    }
}

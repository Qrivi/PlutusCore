package be.plutus.core.service;

import be.plutus.core.config.Config;
import be.plutus.core.model.account.Account;
import be.plutus.core.model.account.AccountStatus;
import be.plutus.core.model.preferences.Preferences;
import be.plutus.core.model.currency.Currency;
import be.plutus.core.repository.AccountRepository;
import be.plutus.core.repository.PreferencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PreferencesRepository preferencesRepository;

    @Override
    public Account getAccount( int id ){
        return accountRepository.findOne( id );
    }

    @Override
    public Account getAccount( String email ){
        return accountRepository.findByEmail( email );
    }

    @Override
    public Account createAccount( String email, String password, Currency defaultCurrency ){
        Account account = new Account();

        account.setEmail( email );
        account.setPlainTextPassword( password );
        account.setStatus( AccountStatus.ACTIVE );
        account.setCreationDate( new Date() );

        if( defaultCurrency == null )
            account.setDefaultCurrency( Config.DEFAULT_CURRENCY );
        else
            account.setDefaultCurrency( defaultCurrency );

        account = accountRepository.save( account );

        Preferences preferences = new Preferences();
        preferences.setAccount( account );
        preferencesRepository.save( preferences );

        return account;
    }

    @Override
    public void updateAccount( int id, String email, String password, Currency defaultCurrency ){
        Account account = accountRepository.findOne( id );

        if( account == null )
            throw new NullPointerException( "Account with id " + id + " was not found" );

        if( email != null )
            account.setEmail( email );
        if( password != null )
            account.setPlainTextPassword( password );
        if( defaultCurrency != null )
            account.setDefaultCurrency( defaultCurrency );

        accountRepository.save( account );
    }

    @Override
    public void removeAccount( int id ){
        Account account = accountRepository.findOne( id );

        if( account == null )
            throw new NullPointerException( "Account with id " + id + " was not found" );

        accountRepository.delete( account );
    }
}

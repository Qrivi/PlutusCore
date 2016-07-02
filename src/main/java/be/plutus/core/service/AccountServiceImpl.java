package be.plutus.core.service;

import be.plutus.core.model.account.Account;
import be.plutus.core.model.account.preferences.Preferences;
import be.plutus.core.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account getAccount( int id ){
        return accountRepository.findOne( id );
    }

    @Override
    public Account getAccount( String email ){
        return accountRepository.findByEmail( email );
    }

    @Override
    public Account createAccount( String email, String password ){
        Account account = new Account();
        account.setEmail( email );
        account.setPlainTextPassword( password );
        account.setPreferences( new Preferences() );
        return accountRepository.save( account );
    }

    @Override
    public void updateAccount( int id, String newEmail, String newPassword ){
        Account account = accountRepository.findOne( id );

        if( account == null )
            throw new NullPointerException( "Account with id " + id + " was not found!" );

        account.setEmail( newEmail );
        account.setPlainTextPassword( newPassword );

        accountRepository.save( account );
    }

    @Override
    public void removeAccount( int id ){
        Account account = accountRepository.findOne( id );

        if( account == null )
            throw new NullPointerException( "Account with id " + id + " was not found!" );

        accountRepository.delete( account );
    }
}
